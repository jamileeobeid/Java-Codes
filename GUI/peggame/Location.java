package peggame;

import java.util.Objects; //importing objects 

public class Location {

    //initiallizing the rows and columns variables
    private int row;
    private int column;

    //creating a constructor
    public Location(int row, int column){
        this.row = row;
        this.column = column;
    }

    //creating getters(accessors)
    public int getRow(){return row;}
    public int getColumn(){return column;}

    //overriding equals() method
    @Override
    public boolean equals(Object obj){

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false; //does the object belong to the same class?

        Location loc = (Location) obj; // casting the object to type Location
        
        return Objects.equals(row, loc.row) && Objects.equals(column,loc.column); // comparing the values for row & column
    }

    //creating hashCode method
    @Override
    public int hashCode(){return Objects.hash(row,column);} // generating hash code based on the rows and columns values

    //creating toString method
    @Override
    public String toString(){
        return "Row: "+getRow()+" Column: "+getColumn();
    }
    
    
}
