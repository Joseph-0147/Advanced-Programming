package Assignment_Solutions;

import java.util.Calendar;

public interface TransactionInterface {
    // Method to get the amount of the transaction
    double getAmount();

    // Method to get the date of the transaction
    Calendar getDate();

    // Method to get the unique transaction ID
    String getTransactionID();

    // Method to print the details of the transaction
    void printTransactionDetails();

    // Method to apply the transaction to a bank account
    // Throws InsufficientFundsException if the transaction cannot be completed due to insufficient funds
    void apply(BankAccount ba) throws InsufficientFundsException;

    /**
     * Reverses the transaction if applicable.
     - @param ba The BankAccount to which the transaction was applied.
     - @return true if the transaction was reversed successfully, false otherwise.
     */
    boolean reverse(BankAccount ba);
}
