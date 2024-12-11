package Assignment_Solutions;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * DepositTransaction Class

 * - This class models a deposit transaction on a bank account.
 * - Deposits add funds to a bank account and are irreversible.

 * Design Considerations:
 * - Specifications define the Requires and Produces interfaces.
 * - Implements abstraction through BaseTransaction.

  @author Joseph Kariuki
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructor: DepositTransaction
     * - Initializes a DepositTransaction with the specified amount and date.

     * @param amount A positive double representing the amount to be deposited. Must be > 0.
     * @param date A non-null Calendar object representing the transaction date.
     * @throws AssertionError if the amount is <= 0.
     * @throws AssertionError if the date is null.
     */

    public DepositTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
        assert amount > 0 : "Amount must be positive.";
        assert date != null : "Date cannot be null.";
    }

    /**
     * apply(BankAccount ba)
     * - Applies the deposit transaction to the specified BankAccount.

     * @param ba A non-null BankAccount object to which the deposit will be applied.
     * @throws IllegalArgumentException if the BankAccount object is null.
     * Produces:
     * - Updates the balance of the given BankAccount by adding the deposit amount.
     * - Prints a message to the console showing the deposit amount and new balance.
     */

    @Override
    public void apply(BankAccount ba) {
        if (ba == null) throw new IllegalArgumentException("BankAccount cannot be null.");

        double newBalance = ba.getBalance() + getAmount();
        ba.setBalance(newBalance);
        System.out.println("Deposit of " + getAmount() + " applied. New balance: " + newBalance);
    }

    /**
     * reverse(BankAccount ba)
     * - Attempts to reverse the deposit transaction. Since deposits are irreversible by design,
     * - this method will simply print a message and return false.

     * @param ba A BankAccount object. (Not used in this method, but included for consistency with the interface.)
     * Produces:
     * - Outputs a message to the console stating that deposits cannot be reversed.
     * @return boolean - Always returns false, indicating that the transaction was not reversed.
     */

    @Override
    public boolean reverse(BankAccount ba) {
        System.out.println("Deposits cannot be reversed.");
        return false;
    }

    /**
     *printTransactionDetails()

     * - Prints the details of this deposit transaction.

     * Produces:
     * - Outputs the transaction type, amount, and date to the console.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        super.printTransactionDetails();
    }
}

