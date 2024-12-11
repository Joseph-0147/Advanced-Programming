package Assignment_Solutions;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

 /**
 WithdrawalTransaction Class

  - This class models a Withdrawal Transaction on a bank account.
  - It allows withdrawals, checks for sufficient funds, and permits reversal of the transaction.

   @author Joseph Kariuki
 */
public class WithdrawalTransaction extends BaseTransaction {
     private boolean reversed = false; // Indicates if the transaction has been reversed.
     private double amountWithdrawn; // Track the actual amount withdrawn

     /**
      * Constructs a WithdrawalTransaction with the specified amount and date.
      * <p>
      * - @param amount The amount to withdraw. Must be positive.
      * - @param date   The date of the transaction. Cannot be null.
      * - @throws IllegalArgumentException if amount is non-positive or date is null.
      */
     public WithdrawalTransaction(double amount, @NotNull Calendar date) {
         super(amount, date);
         assert amount > 0 : "Amount must be positive.";
         assert date != null : "Date cannot be null.";
     }

     /**
      * Applies the withdrawal to the specified bank account.
      * <p>
      * - @param ba The BankAccount object to deduct the withdrawal amount from. Cannot be null.
      * - @throws InsufficientFundsException If the account balance is insufficient for the withdrawal.
      * - @throws IllegalArgumentException  If the BankAccount parameter is null.
      */
     @Override
     public void apply(BankAccount ba) throws InsufficientFundsException {
         if (ba == null) {
             throw new IllegalArgumentException("BankAccount cannot be null.");
         }
         if (reversed) {
             System.out.println("Transaction already reversed.");
             return;
         }

         double currentBalance = ba.getBalance();
         if (currentBalance < getAmount()) {
             if (currentBalance > 0) {
                 System.out.println("Withdrawing partial amount of " + currentBalance + " due to insufficient funds.");
                 ba.setBalance(0);
                 amountWithdrawn = currentBalance; // Record the amount actually withdrawn
                 throw new InsufficientFundsException("Not enough funds to complete the withdrawal. " +
                         "Remaining amount: " + (getAmount() - currentBalance));
             } else {
                 throw new InsufficientFundsException("Insufficient funds for withdrawal.");
             }
         } else {
             ba.setBalance(currentBalance - getAmount());
             amountWithdrawn = getAmount(); // Record the full withdrawal amount
             System.out.println("Withdrawal of " + getAmount() + " applied. New balance: " + ba.getBalance());
         }
     }

     /**
      * Reverses the withdrawal transaction by restoring the withdrawn amount to the account balance.
      * <p>
      * - @param ba The BankAccount object to restore the withdrawn amount. Cannot be null.
      * - @return true if the transaction was successfully reversed, false if it was already reversed.
      * - @throws IllegalArgumentException If the BankAccount parameter is null.
      */
     @Override
     public boolean reverse(BankAccount ba) {
         if (!reversed) {
             ba.setBalance(ba.getBalance() + amountWithdrawn);
             reversed = true;
             System.out.println("Withdrawal reversed. New balance: " + ba.getBalance());
             return true;
         } else {
             System.out.println("Transaction already reversed.");
             return false;
         }
     }

         /**
          Prints the details of the withdrawal transaction.
          Includes the amount, date, and transaction ID.
          */
         @Override
         public void printTransactionDetails(){
             System.out.println("Withdrawal Transaction:");
             super.printTransactionDetails();
         }
     }