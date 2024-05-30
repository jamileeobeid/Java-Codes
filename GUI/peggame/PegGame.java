package peggame;

import java.util.Collection; //importing collection

public interface PegGame {

    //creating our abstract methods
    public abstract Collection<Move> getPossibleMoves();
    
    public abstract GameState getGameState();

    //in the below method, we will throw an exception if the move is invalid
    public void makeMove(Move move) throws PegGameException;
}
