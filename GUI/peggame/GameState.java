package peggame;

import java.util.Collection;

/* This enum class includes the enumeration that
*represents the possible states of the game */

public enum GameState implements PegGame{

    NOT_STARTED,
    IN_PROGRESS,
    STALEMATE,
    WON;

    //adding and overriding the implemented methods from PegGame interface

    @Override
    public Collection<Move> getPossibleMoves() {
        return null;
    }
    
    @Override
    public GameState getGameState(){
        return this;
    }

    @Override
    public void makeMove(Move move) throws PegGameException{};

    //overriding toString() method
    @Override
    public String toString(){

        return "The current game state is: "+ this.name();

    }

}