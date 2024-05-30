package peggame;

/* In this file:
 * We gave a contructor that takes a message as input 
 * This class also allows to create custom exceptions with specific errors
 * that may occur
*/

public class PegGameException extends Exception{

    //creating the constructor
    public PegGameException(String message) { 
        super(message);
    }
}
