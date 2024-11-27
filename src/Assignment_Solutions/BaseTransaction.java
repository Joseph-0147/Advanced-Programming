package Assignment_Solutions;

import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    public BaseTransaction(double amount, Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        this.transactionID = date.getTimeInMillis() + "-" + (int) (Math.random() * 10000);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: "+ "Ksh" + amount);
        System.out.println("Date: " + date.getTime());
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        // Generic implementation
        System.out.println("BaseTransaction applied. No change in account balance.");
    }
}
