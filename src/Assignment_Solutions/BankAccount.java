package Assignment_Solutions;

/**
 * BankAccount
 
 * Represents a bank account with a balance. Provides methods to retrieve and update the balance.
 * This class is used in transaction operations such as deposits and withdrawals.
 
   @author Joseph Kariuki
 */
public class BankAccount {

    // Variable to hold the account balance
    private double balance;

    /**
     * Constructor: BankAccount
     * Initializes a bank account with the specified balance.
     
     * @param balance double - The initial balance of the account. Must be >= 0.
     * Produces:
     *  - A BankAccount object with the specified starting balance.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * getBalance()
     * Retrieves the current balance of the bank account.
     
     * @return double - The current account balance.
     * Produces:
     *  - The monetary amount currently in the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setBalance()
     * Updates the balance of the bank account.
     
     * @param balance double - The new balance to set for the account. Must be >= 0.
     * Produces:
     *  - Updates the account balance to the specified value.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
