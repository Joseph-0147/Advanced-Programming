package Assignment_Solutions;

/**
 * InsufficientFundsException
 
 * This exception is thrown when a transaction cannot be completed due to insufficient funds
 * in the associated bank account.
 
   @author Joseph Kariuki
 */
public class InsufficientFundsException extends Exception {

    /**
     * Constructor: InsufficientFundsException
     * Initializes the exception with a specific error message.
     
     * @param message String - A descriptive message indicating the reason for the exception.
     * Produces:
     *  - An exception object with the provided error message.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
