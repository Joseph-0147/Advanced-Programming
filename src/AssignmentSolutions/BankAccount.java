package AssignmentSolutions;

public class BankAccount {
    // Variable to hold the account balance
    private double balance;

    // Constructor to initialize the bank account with a specified balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to retrieve the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Method to set or update the balance of the account
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
