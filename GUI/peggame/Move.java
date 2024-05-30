package peggame;

import java.util.Collection;
import java.util.Objects;

public class Move implements PegGame{

    //initializing our variables
    private Location from;
    private Location to;

    //creating a constructor 
    public Move(Location from, Location to){
        this.from = from;
        this.to = to;
    }

    //creating the getters(accessors)
    public Location getFrom(){return from;}
    public Location getTo(){return to;}
    

    //overriding equals() method
    @Override
    public boolean equals(Object o) {
    
    if (this == o) return true; //checking if the object being compared is the same instance
    
    //if the object is not an instance of Move, we will return false
    if (!(o instanceof Move)) return false;
    
    Move other = (Move) o; //casting the object to Move
    
    //checking if 'from' and 'to' locations of both Move objects are equal
    return Objects.equals(from, other.from) && Objects.equals(to, other.to);}


    //overriding hashCode() method
    @Override
    public int hashCode(){ return Objects.hash(from, to);} //returning the object's hash

    //creating toString method
    @Override
    public String toString(){
        return "from: "+getFrom()+" to: "+getTo();
    }


    //adding and overriding the implemented methods from PegGame interface
    @Override
    public Collection<Move> getPossibleMoves() {
        return null;
    }
    
    @Override
    public GameState getGameState(){
        return getGameState();
    };

    @Override
    public void makeMove(Move move) throws PegGameException{};
}
