package peggame;

import java.util.ArrayList; //importing ArrayList
import java.util.Collection; //importing Collection
import java.util.List; //importing list 

public class SquareBoard extends Project1Main implements PegGame {

    //creating our private variable
    private int[][] squareBoardResult;

    //creating a constructor
    public SquareBoard(int rows, int columns, int[][] squareBoardResult){
        this.squareBoardResult = squareBoardResult;
    }

    /* we will represent the square game board as a two-dimentional array */
    public static int[][] squareBoard(int rows, int columns) {

        int[][] square = new int[rows][columns];
        return square; //returning the square board
    }

    //adding and overriding the methods from PegGame interface
    @Override
    public Collection<Move> getPossibleMoves(){

        //creating an ArrayList
        List<Move> possibleMoves = new ArrayList<>();

        //creating our variables
        int numOfRows = squareBoardResult.length;
        int numOfCols = squareBoardResult[0].length; //calculating number of columns from the first row

        //iterating over each row in the board
        for (int i = 0; i < numOfRows; i++) {

            //iterating over each column in the board
            for (int j = 0; j < numOfCols; j++) {

                //checking if there is a peg at the current position
                if (squareBoardResult[i][j] == 1) {

                    //if there is a peg, we will make the peg jump over

                    /*'i >= 2'  this condition will ensure that there are at least two rows above the current position,
                    allowing for a jump to occur. 

                    'squareBoardResult[i - 1][j] == 1' will check if there is a peg above the current peg.
                    If there is, that mean we have a possible jump.

                    'squareBoardResult[i - 2][j] == 0' will check if the position two rows above the current position
                    is empty. If it is empty, the peg can jump over.*/

                    if (i >= 2 && squareBoardResult[i - 1][j] == 1 && squareBoardResult[i - 2][j] == 0) {

                        //adding a move if there's an empty space two rows above the current position
                        possibleMoves.add(new Move(new Location(i, j), new Location(i - 2, j)));
                    }

                    //now, we will repeat the same procedure as above, however, this will check two columns to the left position

                    if (j >= 2 && squareBoardResult[i][j - 1] == 1 && squareBoardResult[i][j - 2] == 0) {

                        //adding a move if there's an empty space two columns to the left of the current position
                        possibleMoves.add(new Move(new Location(i, j), new Location(i, j - 2)));
                    }
            }
        }
    }

    return possibleMoves; };
    
    //overriding the GameState method from the PegGame class
    @Override
    public GameState getGameState(){

        Collection<Move> possibleMoves = getPossibleMoves();

        //if no moves are left, it's a Stalemate
        if (possibleMoves.isEmpty()) {
            return GameState.STALEMATE;
        }

        //else, the game is still in progress
        return GameState.IN_PROGRESS;
    };

    //now, we will create a method that will check whether the location entered by the user is valid or not 
    public boolean NotaValidLocation(Location location) {

        int row = location.getRow();
        int col = location.getColumn();

        //logically, rows and columns should start from index 0. Moreover, they should be the same size as our game board
        return row >= 0 && row < squareBoardResult.length && col >= 0 && col < squareBoardResult[0].length;
    }

    //overriding the GameState method from the PegGame class
    @Override
    public void makeMove(Move move) throws PegGameException {

        Location start = move.getFrom(); //start is from which position the peg is moving 
        Location end = move.getTo(); //end is to which position the peg is going

        //if the move is out of bound of the Game Board, we will display an error
        if (!NotaValidLocation(start) || !NotaValidLocation(end)) {
            throw new PegGameException("The move you've entered is out of bounds. Try again.");
        }

        //r1 c1 r2 c2, we will create variables to get those values from the user
        int startRow = start.getRow();
        int startCol = start.getColumn();
        int endRow = end.getRow();
        int endCol = end.getColumn();

        //if the user enters a move from a position with no pegs, we will show an error
        if (squareBoardResult[startRow][startCol] == 0) {
            throw new PegGameException("The start position you entered 'r1 c1' has no pegs. Try again.");
        }

        //diplaying an error if the user is moving a peg to a position that has a peg
        if (squareBoardResult[endRow][endCol] == 1) {
            throw new PegGameException("There is a peg in end position 'r2 c2'. Try again.");
        }

        int jumpedRow = (startRow + endRow) / 2; //calculating the # of rows the peg will jump over
        int jumpedCol = (startCol + endCol) / 2; //calculating the # of columns the peg will jump over

       //updating our game board
        squareBoardResult[startRow][startCol] = 0; //removing the peg from it's start position
        squareBoardResult[jumpedRow][jumpedCol] = 0; //if there's a peg in between the two positions, we will remove it
        squareBoardResult[endRow][endCol] = 1; //placing the peg at the end position
    }
    
    //creating a constructor
    public SquareBoard(int rows, int columns) {
        squareBoardResult = squareBoard(rows, columns);
    }

    //now, we will override the toString() method to display the board
    @Override
    public String toString() {
        String result = "";

        //creating a for loop that will iterate through each row creating our square board game
        for (int[] row : squareBoardResult) {

            for (int hole : row) {

                if (hole == 0) {result += ".";} //if a hole is empty, we will use '.' to represent it

                else {result += "o";} //else, there's a peg in the hole, we will represent it using 'o'

                result += " ";} //adding a space between each peg & hole in the output representation

            result += "\n"; //adding a new line for each row
        }
        return result; //returning the result
    }

    public int getColumns() {
        return squareBoardResult[0].length;
    }
    
    public int getRows() {
        return squareBoardResult.length;
    }
    
    //returning true if there is a peg at the specified row and column, and false otherwise.
    public boolean hasPeg(int row, int column) {
        return squareBoardResult[row][column] == 1;
    }
    

    
}
