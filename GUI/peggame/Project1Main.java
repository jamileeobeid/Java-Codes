package peggame;

import java.io.FileNotFoundException; //importing FileNotFoundException
import java.util.Scanner; //importing scanner
public class Project1Main {
    
    //declaring our main method
    public static void main(String[] args) {

        Scanner myscanner = new Scanner(System.in); //creating a scanner

        //using try/catch incase the user doesn't enter the correct filename
        try{
            System.out.print("Enter the filename: "); //Asking the user to enter the filename

            String filename = myscanner.nextLine(); //Taking the user's input 

            //reading the game board from the file and creating a PegGame instance
            PegGame mygame = FileReader.filereader(filename);

            CommandLineGame.playPegGame(mygame); //using the command-line interface to play the game
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        myscanner.close(); //closing the scanner
    }
  
}