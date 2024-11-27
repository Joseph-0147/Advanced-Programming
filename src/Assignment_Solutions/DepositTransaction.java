package Assignment_Solutions;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    // Constructor for creating a deposit transaction with a specified amount and date
    public DepositTransaction(double amount, Calendar date) {
        super(amount, date); // Call the constructor of the superclass (BaseTransaction)
    }

    // Method to apply the deposit transaction to a bank account
    @Override
    public void apply(BankAccount ba) {
        double newBalance = ba.getBalance() + getAmount();  // Calculate the new balance after the deposit
        ba.setBalance(newBalance);  // Update the bank account with the new balance
        System.out.println("Deposit of " + getAmount() + " applied. New balance: " + newBalance);  // Print confirmation of the deposit and the new balance
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        // Call the superclass method to print common transaction details
        super.printTransactionDetails();
    }
}
