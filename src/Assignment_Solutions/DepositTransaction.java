package Assignment_Solutions;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 DepositTransaction Class

 This class models a deposit transaction on a bank account.
 Deposits add funds to a bank account and are irreversible.

 -> Design Considerations:
 - Specifications define the Requires and Produces interfaces.
 - Implements abstraction through BaseTransaction.
 */
public class DepositTransaction extends BaseTransaction {  // Constructor for creating a deposit transaction with a specified amount and date

    /**
     @param amount A positive double, representing the amount to deposit.
     @param date A non-null Calendar object representing the transaction date.

     -> Requires:
     - `amount` must be positive.
     - `date` must not be null.
     -> Produces:
     - Initializes a DepositTransaction object with the given amount and date.
     */
    public DepositTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     apply(BankAccount ba)

     Applies this deposit transaction to the given BankAccount.

     @param ba A non-null BankAccount object to which the transaction will be applied.

     -> Requires:
     - `ba` must not be null.

     -> Produces:
     - Adds the transaction amount to the BankAccount balance.

     -> Pre-condition:
     - BankAccount exists with a non-null balance.
     -> Post-condition:
     - The BankAccount's balance is updated to include the deposit amount.
     */
    @Override
    public void apply(BankAccount ba) {
        double newBalance = ba.getBalance() + getAmount();
        ba.setBalance(newBalance);
        System.out.println("Deposit of " + getAmount() + " applied. New balance: " + newBalance);
    }

    /**
     printTransactionDetails()

     Prints the details of this deposit transaction.

     -> Produces:
     - Outputs the transaction type, amount, and date to the console.
     */

    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        super.printTransactionDetails();
    }
}

