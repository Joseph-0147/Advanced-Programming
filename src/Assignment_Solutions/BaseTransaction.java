package Assignment_Solutions;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 BaseTransaction Class
 This class provides a foundation for all transaction types.
 It implements the TransactionInterface and defines common methods.
 */
public class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    /**
     Constructor: BaseTransaction

     -> Requires:
     - `amount` must be positive.
     - `date` must not be null.
     - `transactionID` must be unique.
     -> Produces:
     - Initializes a transaction with the specified amount, date, and ID.
     */
    public BaseTransaction(double amount, @NotNull Calendar date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = generateTransactionID();
    }

    private String generateTransactionID() {
        return "-" + System.currentTimeMillis();
    }

    /**
     getAmount()
     @return The transaction amount.
     -> Produces:
     - Returns a positive double representing the transaction amount.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     getDate()
     @return A defensive copy of the transaction date.
     -> Produces:

     - Returns a Calendar object representing the transaction date.
     */
    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    /**
     getTransactionID()
     @return The unique transaction ID.
     -> Produces:
     - Returns a String representing the unique ID for this transaction.
     */
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    /**
     printTransactionDetails()
     -> Produces:
     - Prints the amount, date, and ID of the transaction to the console.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException{
        throw new UnsupportedOperationException("BaseTransaction cannot apply transactions directly.");
    }
}
