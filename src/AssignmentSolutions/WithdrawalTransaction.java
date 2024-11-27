package AssignmentSolutions;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;
    private double amountWithdrawn; // Track the actual amount withdrawn

    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (reversed) {
            System.out.println("Transaction already reversed.");
            return;
        }

        double balance = ba.getBalance();
        if (balance < getAmount()) {
            if (balance > 0) {
                System.out.println("Withdrawing partial amount of " + "Ksh" + balance + " due to insufficient funds.");
                ba.setBalance(0);
                amountWithdrawn = balance; // Record the amount actually withdrawn
                throw new InsufficientFundsException("Not enough funds to complete the withdrawal. " +
                        "Remaining amount: " + "Ksh" + (getAmount() - balance));
            } else {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
        } else {
            ba.setBalance(balance - getAmount());
            amountWithdrawn = getAmount(); // Record the full withdrawal amount
            System.out.println("Withdrawal of " + "Ksh" + getAmount() + " applied. New balance: " + "Ksh" + ba.getBalance());
        }
    }

    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            // Add back the actual amount withdrawn (which could be less than the original request)
            ba.setBalance(ba.getBalance() + amountWithdrawn);
            reversed = true;
            System.out.println("Withdrawal reversed. New balance: " + "Ksh" + ba.getBalance());
            return true;
        } else {
            System.out.println("Transaction already reversed.");
            return false;
        }
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        super.printTransactionDetails();
    }
}
