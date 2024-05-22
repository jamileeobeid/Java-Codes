public class Queen {
    private final int row;
    private final int col;

    /**
     * A string representation of the queen, suitable for printing to standard
     * output.
     */
    private final String string;

    /**
     * The hash code for the queen.
     */
    
    private final int hashCode;

    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
        this.string = "Queen{row=" + row + ", col=" + col + "}";
        this.hashCode = string.hashCode();
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    /**
     * Returns true if this queen can attack the enemy queen, meaning that
     * they are aligned along the same row, column, or diagonal.
     * 
     * @param enemy The enemy queen.
     * 
     * @return True if this queen can attack the enemy queen (and vice versa).
     */
    public boolean canAttack(Queen enemy) {
        return canAttack(enemy.row, enemy.col);
    }

    public boolean canAttack(int row, int col) {
        //my current location - enemy location
        int rowDelta = this.row - row;
        int colDelta = this.col - col;

        return rowDelta == 0 
            || colDelta == 0
            || rowDelta == colDelta
            || rowDelta == -colDelta;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Queen) {
            Queen other = (Queen)obj;
            return this.row == other.row && this.col == other.col;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return string;
    }
    
}
