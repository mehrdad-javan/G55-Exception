package se.lexicon;

import se.lexicon.exception.ExceptionHandler;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount account1 = new BankAccount(1, 500);

            account1.deposit(100);
            System.out.println(account1);

            account1.withdraw(-2000);

        } catch (Exception e) {
            ExceptionHandler.handleExceptions(e);
        }


    }
}