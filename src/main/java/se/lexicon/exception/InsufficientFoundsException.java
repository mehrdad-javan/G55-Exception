package se.lexicon.exception;

public class InsufficientFoundsException extends Exception {

    private double amount;
    private double balance;

    public InsufficientFoundsException(String message, double amount, double balance) {
        super(message);
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Error happened: " + getMessage() + "amount=" + amount + ", balance=" + balance;
    }
}
