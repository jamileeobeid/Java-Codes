package peggame;

import java.io.File; //importing File
import java.io.FileNotFoundException; //importing FileNotFoundException
import java.util.Scanner; //importing Scanner

public class FileReader {

    //creating a method to read a file and then return the PegGame
    public static PegGame filereader(String filename) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(filename));

        //creating a variable that will read and store the number of rows from the first line
        int rows = Integer.parseInt(scanner.nextLine().strip()); //strip() will remove extra white space

        //now, we will read each line to build our board array
        String[] lines = new String[rows]; //creating an array of type String to read each line

        //using a for loop that will iterate through the rows
        for (int i = 0; i < rows; i++) {
            lines[i] = scanner.nextLine().strip();
        }

        scanner.close(); //closing the scanner

        //creating a square board 
        return createBoard(rows, lines);
    }

        //now, we will create a method that will build a SquareBoard instance
        private static SquareBoard createBoard(int rows, String[] lines) {

            //creating a two-dimentional array to represent the SquareBoard
            int[][] squareBoard = new int[rows][];

            //we will create a for loop to iterate over each line to construct the board
            for (int i = 0; i < rows; i++) {

                String line = lines[i]; //i represents the current line, it will store it in a string variable 'line'
                int[] row = new int[line.length()]; //creating an array to represent the current row 


                /* creating a for loop to convert:
                * 1. empty holes (.) to 0's
                * 2. full holes (o) to 1's
                * 
                * this will help us to easily know the state of the board,
                * in order to check for valid moves and end game conditions*/

                for (int j = 0; j < line.length(); j++) {

                    if (line.charAt(j) == 'o') {row[j] = 1;} 
                    else {row[j] = 0;}
                    
                }
                squareBoard[i] = row;
            }

            return new SquareBoard(rows, rows, squareBoard); //returning a new SquareBoard
        }
}
