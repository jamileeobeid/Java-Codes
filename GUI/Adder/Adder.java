// importing the required imports for our JavaFX
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

// imports for GridePane
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;
import javafx.geometry.Insets;

// imports to customize texts
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

// imports for textfields
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// imports for the background
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

// imports for image
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Adder extends Application{

    // creating GUI components
    private TextField text1;
    private TextField text2;
    private TextField text3;

    Button addButton = new Button("Add"); // creating a button

    @Override
    public void start(Stage stage){
        stage.setTitle("Adding two Numbers");

        // creating layout for GUI components
        GridPane mygrid = new GridPane();
        mygrid.setPadding(new Insets(20, 20, 20, 20));
        mygrid.setVgap(10);
        mygrid.setHgap(10);

        // creating labels for text fields
        Label mylabel1 = new Label("Number 1");
        Label mylabel2 = new Label("Number 2");
        Label mylabel3 = new Label("Sum =");

        //customizing the text for myLabel1
        mylabel1.setFont(new Font("Times New Roman", 40)); // setting text font and size
        mylabel1.setAlignment(Pos.CENTER); // adjusting the alingment

        //customizing the text for myLabel2
        mylabel2.setFont(new Font("Times New Roman", 40)); // setting text font and size
        mylabel2.setAlignment(Pos.CENTER); // adjusting the alingment

        //customizing the text for myLabel3
        mylabel3.setFont(new Font("Times New Roman", 40)); // setting text font and size
        mylabel3.setAlignment(Pos.CENTER); // adjusting the alingment

        //adding a background color for all labels
        mylabel1.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
        mylabel2.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
        mylabel3.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

        // creating text fields for user input
        text1 = new TextField();
        text2 = new TextField();
        text3 = new TextField();

        /*Our third text field will display the sum of
         * the first text field and second text field,
         * therefore it should be read-only*/
        text3.setEditable(false);

        // adding an image 
        Image myimage = new Image("image.jpg");
        ImageView myview = new ImageView(myimage);
        HBox mybox = new HBox();
        mybox.getChildren().add(myview);

        // resizing the image to an appriopriate size
        myview.setFitWidth(100);
        myview.setFitHeight(110);

        // adding the image to the grid
        mygrid.add(myview, 0, 0, 1 ,1);

        // aligning the image to top left 
        GridPane.setValignment(myview, VPos.TOP);
        GridPane.setHalignment(myview, HPos.LEFT);

        // creating layout for GUI components
        mygrid.add(mylabel1, 2, 0);
        mygrid.add(text1, 3, 0);
        mygrid.add(mylabel2, 2, 1);
        mygrid.add(text2, 3, 1);
        mygrid.add(mylabel3, 2, 2);
        mygrid.add(text3, 3, 2);

        // adding the button to the grid
        mygrid.add(getButton(), 3, 3);

        // creating scene and set it on the primary stage
        Scene s = new Scene(mygrid, 500, 330);
        stage.setScene(s);
        stage.show();

        // now, we will call the addNumbers() method when the user presses on the button
        getButton().setOnAction(e-> {addNumbers();});
    }

    // creating a method to display the button 
    public Button getButton(){ return addButton;}

    // creating a method that adds the first and second number
    private void addNumbers(){

        // using try/catch to avoid non-numerical inputs
        try{
            double num1 = Double.parseDouble(text1.getText()); // getting the text from the first field
            double num2 = Double.parseDouble(text2.getText()); // getting the text from the second field
            double sum = num1 + num2; // calculating the sum

            text3.setText("Sum= "+sum);
        }

        //sending an error text to the user incase they entered a non-numerical value
        catch(NumberFormatException e){
            text3.setText("Please enter valid numbers..");
        }
    }

    // creating our main method
    public static void main(String[] args) {
        launch(args);
    }
    
}
