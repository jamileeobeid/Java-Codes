import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NQueens implements Configuration {

    private final Queen[] queens;
    //number of queens
    private final int n;

    public NQueens(int n) {
        //create new queens object and call super class with element [0]
        this(n, new Queen[0]);
    }

    public NQueens(int n, Queen[] queens) {
        this.n = n;
        //if zeroth element is not null assign it-> this.queens=queens , if its null create new queen.
        this.queens = queens != null ? queens : new Queen[0];
    }

    public Queen[] getQueens() {
        return queens;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        //the goal is to see possible locations for the next row
        List<Configuration> successors = new ArrayList<>();
        //current number of queens on the board
        int length = queens.length;
        //Getting the next row after last queen. If the board is empty, the "next" row is the first row.
        int row = length > 0 ? queens[length-1].getRow() + 1 : 0;
        //if row<n I can add a new queen
        if(row < n) {
            //for each column of the next row I am going to create new queen
            for(int col=0; col<n; col++) {
                //create new array with +1 space. because I am going to add another queen
                Queen[] copy = Arrays.copyOf(queens, length+1);
                //create new queen and add it to the end and add it to successors
                copy[length] = new Queen(row, col);
                successors.add(new NQueens(n, copy));
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if(length < 2) {
            return true;
        } else {
            Queen last = queens[length-1];
            for(int i=0; i<length-1; i++) {
                //checks if the last can attack others
                if(last.canAttack(queens[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length == n;
    }

    @Override
    public String toString() {
        String[][] board = new String[n][n];
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                board[row][col] = "[ ]";
            }
        }

        for(Queen q : queens) {
            board[q.getRow()][q.getCol()] = "[Q]";
        }
        //Stringbuilder helps to create new text. it has append etc. methods
        StringBuilder builder = new StringBuilder();
        for(String[] row : board) {
            for(String col : row) {
                builder.append(col);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Backtracker backtracker = new Backtracker(false);
        NQueens nQueens = new NQueens(4);
        Configuration solution = backtracker.solve(nQueens);
        if(solution == null) {
            System.out.println("no solution");
        } else {
            System.out.println(solution);
        }
    }
    
}
