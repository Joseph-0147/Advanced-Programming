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
     * Constructor: BaseTransaction

     -> Requires:
     - @param amount A positive double, representing the transaction amount. Must be > 0.
     - @param date A non-null Calendar object representing the transaction date.
     - @throws IllegalArgumentException if amount <= 0 or date is null.
     -> Produces:
     - Initializes a BaseTransaction with the specified amount and date.
     */
    public BaseTransaction(double amount, @NotNull Calendar date) {
        if (amount <= 0) throw new IllegalArgumentException("Transaction amount must be positive.");
        if (date == null) throw new IllegalArgumentException("Transaction date cannot be null.");

        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = generateTransactionID();
    }

    /**
     getAmount()
     @return double - The amount associated with the transaction.
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
     * apply(BankAccount ba)
     - Applies the transaction to a given BankAccount.

     - @param ba A non-null BankAccount object.
     - @throws UnsupportedOperationException if the method is called directly on BaseTransaction.
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        throw new UnsupportedOperationException("apply() must be implemented in subclasses.");
    }

    /**
     * reverse(BankAccount ba)
     - Attempts to reverse the transaction.

     - @param ba A non-null BankAccount object.
     - @return boolean - Returns true if the transaction is reversed successfully.
     - @throws UnsupportedOperationException if reverse is not supported by the transaction type.
     */
    @Override
    public boolean reverse(BankAccount ba) {
        throw new UnsupportedOperationException("Reverse operation is not supported for this transaction type.");
    }

    /**
      printTransactionDetails()

      Prints details of the transaction.
     -> Produces:
     - Outputs transaction type, ID, amount, and date to the console.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    /**
     * generateTransactionID()
     Generates a unique identifier for this transaction.
     @return String - A unique transaction ID.
     */
    private String generateTransactionID() {
        return  System.currentTimeMillis() + "-" + (int) (Math.random() * 10000);
    }
}
