package Assignment_Solutions;

import java.util.Calendar;

/**
 * TransactionInterface

 * - This interface defines the common behaviors and attributes of all transaction types in the system.
 * - Classes implementing this interface must provide concrete implementations for handling transaction
 * - details, applying transactions, and optionally reversing them.

  @author Joseph Kariuki
 */

public interface TransactionInterface {
    /**
     * Retrieves the amount of the transaction.

     * @return double - The monetary amount of the transaction. Must be a positive value.
     * Produces:
     * - The value representing the transaction amount.
     */
    double getAmount();

    /**
     * Retrieves the date of the transaction.

     * @return Calendar - A copy of the transaction date as a Calendar object.
     * Produces:
     * - The date on which the transaction occurred.
     */
    Calendar getDate();

    /**
     * Retrieves the unique identifier of the transaction.

     * @return String - A unique transaction ID that can be used for tracking and identification.
     * Produces:
     * - A unique string representing the transaction ID.
     */
    String getTransactionID();

    /**
     * Prints the details of the transaction.

     * Produces:
     * - Outputs the transaction details to the console, including type, ID, amount, and date.
     */
    void printTransactionDetails();

    /**
     * Applies the transaction to a specified bank account.

     * @param ba BankAccount - The bank account to which the transaction is to be applied.
     * Requires:
     * - The BankAccount object must not be null.
     * Produces:
     * - Updates the balance of the bank account based on the transaction type and amount.
     * @throws InsufficientFundsException if the transaction cannot be completed due to insufficient funds.
     */
    void apply(BankAccount ba) throws InsufficientFundsException;

    /**
     * Reverses the transaction if applicable.

     * @param ba BankAccount - The bank account to which the transaction was applied.
     * Requires:
     *  - The BankAccount object must not be null.
     * Produces:
     *  - Reverts the effects of the transaction on the bank account balance, if reversal is supported.
     * @return boolean - Returns true if the transaction was successfully reversed, false otherwise.
     */
    boolean reverse(BankAccount ba);
}
