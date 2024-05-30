package peggame;

import java.util.Scanner;

public class CommandLineGame {

    /*creating a static method that;
    given any instance of the PegGame interface will allow a user to:
    a. enter commands into standard input
    b. play until completion or until they quit. */

    public static void playPegGame(PegGame game) {

        Scanner myscanner = new Scanner(System.in); //creating our scanner

        System.out.println("The current state of the board is: \n"+game.toString());  //showing the player the initial board state

        //looping the PegGame using a while loop
        while (true) {

            //now, we will ask the user to enter a command or quit
            System.out.println("Enter a command: \n1. move r1 c1 r2 c2 \n2. quit");
            String userinput = myscanner.nextLine().strip(); //storing the user input

            //if the user enters 'quit' we will end the game
            if (userinput.equals("quit")) {
                System.out.println("Game Ended");
                break;}

            //if the user makes a move, we will move the peg
            else if (userinput.startsWith("move")) {

                /*we will split the user's input into an array of strings 
                *to access each component of the command 'move' seperately
                it will help us to execute the 'move' command accurately*/
                String[] parts = userinput.split("\\s+");

                /*the correct format is: 'move r1 c1 r2 c2';
                 *this means, the form consists of 5 parts.
                 if the user's input does not consists of 5 parts,
                 it means that their input is invalid. Therefore,
                 we will print an error message notifying the user*/
                if (parts.length != 5) {
                    System.out.println("Your 'move' command is invalid.\nCorrect Format: move r1 c1 r2 c2");
                    continue;
                }

                //we will use try/catch to eliminate any exceptions found
                try {

                    //initializing our rows and columns variables 
                    int r1 = Integer.parseInt(parts[1]);
                    int c1 = Integer.parseInt(parts[2]);
                    int r2 = Integer.parseInt(parts[3]);
                    int c2 = Integer.parseInt(parts[4]);

                    //creating a new move to a new location
                    Move move = new Move(new Location(r1, c1), new Location(r2, c2));
                    game.makeMove(move);

                    //now, we will check the state of the game
                    GameState gameState = game.getGameState();

                    //if the game is 'WON', we will tell the user and end the game
                    if (gameState == GameState.WON) {
                        System.out.println("Congratulations! You won!");
                        break;
                    } 

                    //if the game is 'stalemate', it means no moves are left, we will end the game
                    else if (gameState == GameState.STALEMATE) {
                        System.out.println("No more valid moves. STALEMATE!");
                        break;
                    }

                    //we will display the current game state for the user
                    System.out.println(game.toString());
                } 
                //if the user makes an invalid move, we will tell them and display a message
                catch (NumberFormatException | PegGameException e) {
                    System.out.println("Invalid move: " + e.getMessage());
                }
            }
            else {System.out.println("Wrong command entered. Please try again and enter 'move' or 'quit'.");}
        }

        myscanner.close(); //closing the scanner
    }

}
