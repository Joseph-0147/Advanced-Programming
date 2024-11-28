package Assignment_Solutions;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 WithdrawalTransaction Class

 This class models a Withdrawal Transaction on a bank account.
 It allows withdrawals, checks for sufficient funds, and permits reversal of the transaction.

 -> Design Considerations:
 - Specifications define the Requires and Produces interfaces.
 - Implements abstraction through BaseTransaction.
 */
public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;
    private double amountWithdrawn; // Track the actual amount withdrawn

    /**
     Constructor: WithdrawalTransaction
     @param amount A positive double, representing the amount to withdraw.
     @param date A non-null Calendar object representing the transaction date.
     -> Requires:
     - `amount` must be positive.
     - `date` must not be null.
     -> Produces:
     - Initializes a WithdrawalTransaction object with the given amount and date.
     */
    public WithdrawalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     apply(BankAccount ba)
     Applies this withdrawal transaction to the given BankAccount.

     @param ba A non-null BankAccount object to which the transaction will be applied.

     -> Requires:
     - `ba` must not be null.
     - The balance in `ba` must be non-negative.
     -> Produces:
     - Deducts the transaction amount from the BankAccount balance if sufficient funds are available.
     - If `balance < amount`, performs a partial withdrawal of the available balance and throws an exception.

     @throws InsufficientFundsException if the account balance is less than the transaction amount.

     -> Pre-condition:
     - `reversed` is false (transaction has not already been reversed).
     -> Post-condition:
     - The BankAccount's balance is updated to reflect the withdrawal.
     - If funds are insufficient, an exception is thrown, and the transaction does not complete.
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (reversed) {
            System.out.println("Transaction already reversed.");
            return;
        }

        double balance = ba.getBalance();
        if (balance < getAmount()) {
            if (balance > 0) {
                System.out.println("Withdrawing partial amount of " + balance + " due to insufficient funds.");
                ba.setBalance(0);
                amountWithdrawn = balance; // Record the amount actually withdrawn
                throw new InsufficientFundsException("Not enough funds to complete the withdrawal. " +
                        "Remaining amount: " + (getAmount() - balance));
            } else {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
        } else {
            ba.setBalance(balance - getAmount());
            amountWithdrawn = getAmount(); // Record the full withdrawal amount
            System.out.println("Withdrawal of " + getAmount() + " applied. New balance: " + ba.getBalance());
        }
    }

    /**
     * reverse(BankAccount ba)
     * Reverses this withdrawal transaction by refunding the amount to the BankAccount.
     *
     * @param ba A non-null BankAccount object to which the reversal will be applied.
     *           -> Requires:
     *           - `ba` must not be null.
     *           - The transaction must not already be reversed.
     *           -> Produces:
     *           - Adds the transaction amount back to the BankAccount balance.
     *           - Sets the `reversed` flag to true to prevent further reversals.
     *           <p>
     *           -> Pre-condition:
     *           - The transaction is not reversed.
     *           -> Post-condition:
     *           - The BankAccount's balance is restored to its pre-withdrawal state.
     *           - `reversed` is set to true.
     */
    public void reverse(BankAccount ba) {
        if (!reversed) {
            // Add back the actual amount withdrawn (which could be less than the original request)
            ba.setBalance(ba.getBalance() + amountWithdrawn);
            reversed = true;
            System.out.println("Withdrawal reversed. New balance: " + "Ksh" + ba.getBalance());
        } else {
            System.out.println("Transaction already reversed.");
        }
    }

    /**
     printTransactionDetails()
     Prints the details of this withdrawal transaction.
     -> Produces:
     - Outputs the transaction type, amount, date, and reversal status to the console.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        super.printTransactionDetails();
        System.out.println("Reversed: " + reversed);
    }
}
