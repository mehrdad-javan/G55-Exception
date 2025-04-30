package se.lexicon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        // Checked-Exception
        // Files.newBufferedReader(Paths.get("dir/skills.txt"));
        // DriverManager.getConnection("jdbc:mysql://localhost:3306", "DB_USERNAME", "DBPASSWORD");

        // Unchecked-Exception
        // int[] numbers = {1, 2, 3, 4};
        // System.out.println(numbers[10]);


        //double result = takeDecimalInput();
        //System.out.println("result = " + result);

        //readTextFile();

        writeToTextFile();
    }

    // Catching Unchecked-Exceptions
    public static Double takeDecimalInput() {

        try (Scanner scanner = new Scanner(System.in);) {
            Double number = null;

            while (true) {
                try {
                    System.out.println("Enter a Number: ");
                    number = scanner.nextDouble();
                    break;
                    // https://emojipedia.org/
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("❌ Invalid input! Please enter a valid decimal number.");
                }
            }
            return number;
        }
    }

    // Catching Checked-Exceptions
    public static void readTextFile() {
        try {
            Path path = Paths.get("dir/skills.txt");
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            // newBufferedReader is used to read a text file.
            // it allows for reading of large files.
            bufferedReader.lines().forEach(s -> System.out.println(s));

            // Relative file path: A path relative to the current directory.
            // Example: dir/skills.txt

            // Absolute file path: A complete path from the root directory on the file.
            // Example: D:\lexicon\g55\G55-Exception\dir\skills.txt

            System.out.println("------------------");

            Files.readAllLines(path).forEach(s -> System.out.println(s));
            // this method is used for reading the smale files.

        } catch (NoSuchFileException e) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            System.out.println("IOException: Something went wrong while reading the file.");
            e.printStackTrace();
        }
    }

    // try catch with finally
    public static void writeToTextFile() {
        Path path = Paths.get("dir/skills.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            bufferedWriter.append("Spring").append("\n").append("React").append("\n");

            //
            //throw new RuntimeException("Runtime Error Happened");
            //

            //bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("IOException: Something went wrong while writing into the file.");
            e.printStackTrace();
        } finally {
            System.out.println("finally block has been executed!");
            // How to close bufferedWriter ?
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    // try-with-resources
    public static void writeToTextFileNew() {
        Path path = Paths.get("dir/skills.txt");
        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        ) {

            bufferedWriter.append("Spring").append("\n").append("React").append("\n");

            //
            //throw new RuntimeException("Runtime Error Happened");
            //

            //bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("IOException: Something went wrong while writing into the file.");
            e.printStackTrace();
        }
    }


}
