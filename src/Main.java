import AssignmentSolutions.*;  // Import all classes from AssignmentSolutions package
import java.util.Calendar;


public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(500);
        Calendar date = Calendar.getInstance();   // Get the current date and time using Calendar

        DepositTransaction deposit = new DepositTransaction(500, date);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(600, date);

        System.out.println("Initial balance: "+ "Ksh" + account.getBalance());   // Display the initial balance of the account

        deposit.apply(account);    // Apply the deposit transaction to the account
        deposit.printTransactionDetails();

        try {    // Try to apply the withdrawal transaction to the account
            withdrawal.apply(account);
        } catch (InsufficientFundsException e) {  // Catch and display an error if there are insufficient funds for the withdrawal
            System.out.println(e.getMessage());
        } finally {
            System.out.println("After withdrawal, balance: "+ "Ksh" + account.getBalance());
        }

        // Reversing withdrawal
        withdrawal.reverse(account);
    }
}
