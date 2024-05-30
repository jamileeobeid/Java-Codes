package peggame;

import javafx.animation.PauseTransition;
import javafx.application.Application;

//importing scenes
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.stage.Stage; //importing stage
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException; //importing FileNotFoundException
import java.io.IOException;
import java.io.PrintWriter;

import javafx.geometry.Pos; //importing Pos
import javafx.event.EventHandler; //importing event handlers
import javafx.scene.input.MouseEvent; //importing mouse event
import javafx.scene.Node; //importing Node

//importing paint and text alignment
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class PegGameGUI extends Application {

    private Button currentButton = null; 
    private Label message;
    private Button quit; //initializing the 'quit' button
    private Button save; //initializing the 'save' button
    private GridPane gameBoard = new GridPane(); //initializing gameBoard as a global variable (so that many methods can access it)
    Label gameStateLabel; //initializing the label of the game state

    @Override
    public void start(Stage primaryStage) {

        //first, we will create a label to show the user the state of the game
        gameStateLabel = new Label("Game State: Not Started");

        //customizing the label
        gameStateLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gameStateLabel.setTextFill(Color.BLUE);
        gameStateLabel.setTextAlignment(TextAlignment.CENTER);

        VBox vbox = new VBox(); //creating a VBOX
        vbox.setAlignment(Pos.CENTER); //aligning it to the centre

        primaryStage.setTitle("Welcome to the Peg Game!"); //giving our GUI a title

        Label fileNameLabel = new Label("Enter the filename: "); //asking the user for a filename

        //customizing the Label font and background color
        fileNameLabel.setFont(Font.font("Footlight MT Light", FontWeight.NORMAL, 30));
        fileNameLabel.setStyle("-fx-background-color: #FFB6C1;"); // #FFB6C1 represents baby pink color according to Java


        TextField fileNameField = new TextField();
        Button playButton = new Button("Display Board and Play!"); //creating a button to start the game

        message = new Label(); //this message label will be used when the user clicks on an invalid move

        quit = new Button("Quit"); //creating the 'quit' button
        save = new Button("Save Game State"); //creating the 'save' button

        //adding event handler that will close the game once the user clicks the 'quit' button
        quit.setOnAction(event -> primaryStage.close());

        //adding event handler that will save the game state once the user clicks the 'Save Game State' button.
        //We will also create a new stage in which the user can wirte the name of the new file they want to save the state in.
        save.setOnAction(event -> {
            
            Stage fileNameStage = new Stage();
            fileNameStage.setTitle("Game State File");

            //take in the name of the new file
            TextField fileGameState = new TextField();
            fileGameState.setPromptText("Enter new file name (with .txt): ");

            //save the name of the file
            Button saveButton = new Button("Save");
            saveButton.setOnAction(e -> {
                String saveFileName = fileGameState.getText();
                saveGameState(saveFileName);
                fileNameStage.close(); 
            });

            
            VBox fileNameLayout = new VBox(10); 
            fileNameLayout.getChildren().addAll(new Label("Enter file name:"), fileGameState, saveButton);
            fileNameLayout.setAlignment(Pos.CENTER);

            
            Scene fileNameScene = new Scene(fileNameLayout, 300, 150);
            fileNameStage.setScene(fileNameScene);
            fileNameStage.show();
        });

        //now we will use try/catch to check whether the user entered the correct filename
        playButton.setOnAction(e -> {
            
            String fileName = fileNameField.getText();

            try {
                PegGame pegGame = FileReader.filereader(fileName);

                //creating a GridPane to represent the game board if the filename entered is correct
                gameBoard = createGameBoard(pegGame);

                VBox gameAndQuitButton = new VBox();
                gameAndQuitButton.getChildren().addAll(gameStateLabel, gameBoard, quit, save, message);
                gameAndQuitButton.setAlignment(Pos.CENTER);

                primaryStage.setScene(new Scene(gameAndQuitButton, 500, 450));//showing the game board scene
                primaryStage.show();

            } catch (FileNotFoundException ex) {
                System.out.println("File not found: " + ex.getMessage());
            }
        });

        vbox.getChildren().addAll(fileNameLabel, fileNameField, playButton);

        Scene scene = new Scene(vbox, 350, 320); //creating a scene
        primaryStage.setScene(scene); //setting the scene
        primaryStage.show(); //showing the scene
    }

    //this method will calculate the board size (number of buttons per row and coloumn)
    private int boardSize(){
        int row = 0;
        int col = 0;

        //this will iterate over the rows and coloumn of the game board
        for(Node nodeButton: gameBoard.getChildren()){
            if(nodeButton instanceof Button){
                Button button = (Button) nodeButton;
                int numRow = GridPane.getRowIndex(button);
                int numCol = GridPane.getColumnIndex(button);

                if(numRow>=row){
                    row = numRow+1;
                }
                if(numCol >= col){
                    col = numCol+1;
                }
            }
        }
        return Math.max(row, col);
    }

    //this method will use the new file name the user inputed to create a new file
    //this method will use filewriter to save the state of the board
    private void saveGameState(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
    
            PrintWriter writer = new PrintWriter(file);
    
            int sizeBoard = boardSize(); //store the size of the board in the sizeBoard variable
            
            //print out the size of the board
            writer.println(sizeBoard);
    
            int counts = 0; //initialize a count
    
            for (Node node : gameBoard.getChildren()) {
                if (node instanceof Button) {
                    Button button = (Button) node;
                    if (button.getGraphic() != null) {
                        writer.print("o "); //'o' will represent the peg
                    } else {
                        writer.print(". "); //'.' will represent the empty space
                    }

                    counts++; //increment the count by 1  
                    
                    if (counts == sizeBoard) {
                        writer.println(); 
                        counts = 0; 
                    }
                }
            }
            
            writer.close();
            System.out.println("Saved the Game State!");
        } catch (IOException e) {
            System.out.println("Error saving the game state: " + e.getMessage());
        }
    }    
    
    //now we will create a method that will check if the user created a valid move or not
    private boolean isValidMove(int currentRow, int currentCol, int destinationRow, int destinationColumn, GridPane gameBoard) {

        //checking if the move is horizontal or vertical (rows means horizontal and columns means vertical)
        //Math.abs() takes the absolute value (so that we have a whole number)
        if ((currentRow == destinationRow && Math.abs(currentCol - destinationColumn) == 2) ||
                (currentCol == destinationColumn && Math.abs(currentRow - destinationRow) == 2)) {
    
            //For horizontal movement (they're row-based)
            if (currentRow == destinationRow) {
    
                //calculating the intermediate column
                int intermediateCol = (currentCol + destinationColumn) / 2;
    
                //checking if the intermediate cell contains a peg and the destination cell is empty
                //or if the intermediate cell contains a peg and the destination cell contains a peg that has already moved
                return (isPegPosition(currentRow, intermediateCol) && !isPegPosition(destinationRow, destinationColumn))
                        || (isPegPosition(currentRow, intermediateCol) && isPegPosition(destinationRow, destinationColumn)
                        && ((Button) getNodeByRowColumnIndex(destinationRow, destinationColumn, gameBoard)).getGraphic() == null);
            }
            //For vertical movement
            else {
    
                //calculating the intermediate row
                int intermediateRow = (currentRow + destinationRow) / 2;
    
                //checking if the intermediate cell contains a peg and the destination cell is empty
                //or if the intermediate cell contains a peg and the destination cell contains a peg that has already moved
                return (isPegPosition(intermediateRow, currentCol) && !isPegPosition(destinationRow, destinationColumn))
                        || (isPegPosition(intermediateRow, currentCol) && isPegPosition(destinationRow, destinationColumn)
                        && ((Button) getNodeByRowColumnIndex(destinationRow, destinationColumn, gameBoard)).getGraphic() == null);
            }
        }
        return false; //else, it is not a valid move if the move is not horizontal or vertical
    }
    
    //creating a method that will create the peggame board
    private GridPane createGameBoard(PegGame pegGame) {

        GridPane gameBoard = new GridPane(); //initializing a GridPane

        //path for peg image
        Image stillPeg = new Image("stillPeg.jpg");

        //path for destination image
        Image movedPeg = new Image("movedPeg.jpg");
        
        //creating an event handler that handles the clicking events for the pegs
        EventHandler<MouseEvent> mouseClickHandler = (e -> {

        Button destinationButton = (Button) e.getSource();

        if (currentButton == null) { //checking that there is no previous button clicked

            if (destinationButton.getGraphic() != null) { //chechking if there is a peg
                currentButton = destinationButton;

                //creating a pink background when a user click a peg
                currentButton.setStyle("-fx-background-color: pink;");
            }

        } else if (currentButton == destinationButton) { // if the same peg is clicked again
            currentButton.setStyle(""); // reset its style
            currentButton = null; // reset currentButton
        } else if (destinationButton.getGraphic() == null) {

            /* cheking if the button clicked is empty, 
            then we will get the row and the columns of the 
            current buttons and the destination  buttons */ 
            int currentRow = GridPane.getRowIndex(currentButton);
            int currentCol = GridPane.getColumnIndex(currentButton);
            int destinationRow = GridPane.getRowIndex(destinationButton);
            int destinationColumn = GridPane.getColumnIndex(destinationButton);
             
            //checking if the peg is followed by an empty space and then a peg
            if (isValidMove(currentRow, currentCol, destinationRow, destinationColumn, gameBoard)) {

                //checking if the user is in Stalemate or Won the game to update the Game Progress
                if (isGameOver()) {
                    if (isGameWon()) {
                        gameStateLabel.setText("Game State: Won");
                    } else if (isStalemate()) {
                        gameStateLabel.setText("Game State: Stalemate");
                    } else {
                        gameStateLabel.setText("Game State: In Progress");
                    }
                } else {
                    gameStateLabel.setText("Game State: In Progress");
                }

                //if move is valid, we will call eatMiddlePeg to remove the peg in-between
                eatMiddlePeg(currentRow, currentCol, destinationRow, destinationColumn);

                //we will remove the image from the position where the peg moved
                currentButton.setGraphic(null);
    
                //adding the new peg image to the destination button
                ImageView imageView2 = new ImageView(movedPeg);
                imageView2.setFitWidth(50);
                imageView2.setFitHeight(50);
                destinationButton.setGraphic(imageView2);

                //we will clear the current button and reset its style
                currentButton.setGraphic(null);
                currentButton.setStyle("");

                currentButton = null; //resetting

                message.setText("");

                } else { // if the move is not valid

                    // we will first show an error message
                    message.setText("Invalid move :( Please select another peg with a valid move.");

                    PauseTransition delay = new PauseTransition(Duration.seconds(2)); // adding delay time 

                    delay.setOnFinished(event -> {
                    currentButton.setStyle(""); // resetting the style of button
                    currentButton = null; // reset currentButton
                    message.setText(""); // we will clear and remove message label
                    //this will ensure that the game allows the user to try another move after making an invalid move
                });
                delay.play();
                }
            }
        });



        //creating the buttons and setting the image to them using for loop
        for (int row = 0; row < 4; row++) {  //iterating as long as rows are from index 0 to 3

            for (int col = 0; col < 5; col++) { //iterating as long as columns are from index 0 to 4

                //creating a new button and setting it's size and alignment
                Button button = new Button();
                button.setPrefSize(70, 70);
                button.setAlignment(Pos.CENTER);
                gameBoard.add(button, col, row); //adding the buttons to the board

                //adding event handler to handle mouse clicks
                button.setOnMouseClicked(mouseClickHandler);

                //checking if there is a peg in the current position then we add the image
                if (isPegPosition(row, col)) {
                    ImageView imageView = new ImageView(stillPeg);
                    imageView.setFitWidth(50); //setting the width of the image
                    imageView.setFitHeight(50); //setting the height of the image
                    button.setGraphic(imageView);
                }
            }
        }
        gameBoard.setAlignment(Pos.CENTER); //aligning the board to the center
        return gameBoard;
    }

    //now, we will create a method that will eat (remove) the peg in the middle 
    private void eatMiddlePeg(int currentRow, int currentCol, int destinationRow, int destinationColumn) {

        //calculating the position of the intermediate cell
        double intermediateRow = (currentRow + destinationRow) / 2.0;
        double intermediateCol = (currentCol + destinationColumn) / 2.0;

        /*iterating through the buttons in the game board using for each loop 
        to find the button representing the intermediate cell*/
        for (Node node : gameBoard.getChildren()) {
            
            if (node instanceof Button) {
                Button button = (Button) node;
                int row = GridPane.getRowIndex(button);
                int col = GridPane.getColumnIndex(button);
            
                //if the button represents the intermediate cell and contains a peg, remove the peg
                if (row == intermediateRow && col == intermediateCol && button.getGraphic() != null) {
                    button.setGraphic(null); //removing the image from the eaten peg
                    return; //exiting the method after removing the peg
                }
            }
        }
    }

    //creating a method that will check if we have a peg in our current position
    private boolean isPegPosition(int row, int col) {

        //initially the peg will be on all buttons except the holes, therefore we will exclude the holes
        return !(row == 0 && col == 2) && !(row == 1 && col == 2) && !(row == 2 && col == 2) && !(row == 3 && col == 2);
    }

    //creating a method to check whether the game is won
    //game is won when there is only one peg left on the board and no valid moves remaining
    private boolean isGameWon() {

        int pegCount = 0; //initializing a variable to count the pegs

        //iterating through all buttons on the game board using 'for each' loop
        for (Node node : gameBoard.getChildren()) {

            //we will continue only if the node is an instance of Button
            if (node instanceof Button) {
                Button button = (Button) node;

                //if we found a peg (by checking if the button has a peg image on it), we will increase our peg count by 1
                if (button.getGraphic() != null && isPegPosition(GridPane.getRowIndex(button), GridPane.getColumnIndex(button))) {
                    pegCount++;
                }
            }
        }

        //if there is only one peg left and no valid moves remaining, the game is won
        return pegCount == 1 && isGameOver();
    }


    //creating a method to checke whether the game is over
    //the game is over when there are no more valid moves
    private boolean isGameOver() {

        //iterating through all buttons on the game board using for each loop
        for (Node node : gameBoard.getChildren()) {

            //we will continue only if the node is an instance of Button
            if (node instanceof Button) {
                Button button = (Button) node;
                int currentRow = GridPane.getRowIndex(button);
                int currentCol = GridPane.getColumnIndex(button);
            
                //checking if the button contains a peg
                if (button.getGraphic() != null && isPegPosition(currentRow, currentCol)) {

                    //checking if the peg has any valid move available
                    for (Node adjacentNode : gameBoard.getChildren()) {

                        if (adjacentNode instanceof Button) {
                            Button adjacentButton = (Button) adjacentNode;
                            int destinationRow = GridPane.getRowIndex(adjacentButton);
                            int destinationColumn = GridPane.getColumnIndex(adjacentButton);

                            //if any valid move is found, the game is not over, therefore we will return false
                            if (isValidMove(currentRow, currentCol, destinationRow, destinationColumn, gameBoard)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true; // If no valid moves are found, the game is over
    }

    //creating a method to check whether the game is in a stalemate
    //stalemate occurs when there are no more valid moves left, but there is more than one peg remaining on the board
    private boolean isStalemate() {

        int pegCount = 0; //initializing a variable to count the pegs

        //iterating through all buttons on the game board using 'for each' loop
        for (Node node : gameBoard.getChildren()) {

            //we will continue only if the node is an instance of Button
            if (node instanceof Button) {
                Button button = (Button) node;
                int currentRow = GridPane.getRowIndex(button);
                int currentCol = GridPane.getColumnIndex(button);

                //checking if the button contains a peg
                if (button.getGraphic() != null && isPegPosition(currentRow, currentCol)) {

                    pegCount++; //incrementing the peg count

                    //checking if the peg has any valid move available
                    for (Node adjacentNode : gameBoard.getChildren()) {

                        if (adjacentNode instanceof Button) {
                            Button adjacentButton = (Button) adjacentNode;
                            int destinationRow = GridPane.getRowIndex(adjacentButton);
                            int destinationColumn = GridPane.getColumnIndex(adjacentButton);

                            //if any valid move is found, the game is not in stalemate, therefore we will return false
                            if (isValidMove(currentRow, currentCol, destinationRow, destinationColumn, gameBoard)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        //if there is more than one peg left and no valid moves remaining, the game is in stalemate
        return pegCount > 1;
    }

    //creating a method to get node by row and column index (this method will help us to make isValidMove() method effective)
    private Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {

        //iterating through the rows and columns using for each loop
        for (Node node : gridPane.getChildren()) {

            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) { //creating our main method
        launch(args);
    }
}
