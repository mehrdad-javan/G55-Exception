package se.lexicon.exception;

public class ExceptionHandler {

    public static void handleExceptions(Exception e) {
        switch (e) {
            case IllegalArgumentException ex -> System.out.println("Invalid Params: " + ex.getMessage());
            case InsufficientFoundsException ex ->
                    System.out.println("InsufficientFounds: " + "Balance: " + ex.getBalance() + " Amount: " + ex.getAmount());
            default -> {
                System.out.println("Unexpected error occurred: ");
                e.printStackTrace();
            }

        }

    }

}
