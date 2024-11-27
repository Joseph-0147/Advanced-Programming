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
}
