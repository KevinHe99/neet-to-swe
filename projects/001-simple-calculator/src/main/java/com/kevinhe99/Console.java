package com.kevinhe99;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {
    public static final String APP_NAME = "Simple Calculator";
    public static final String VERSION = "0.1.250802a";

    private final Scanner scanner;
    private final PrintStream output;
    private boolean loopConsole;

    public boolean isLoopConsole() {
        return loopConsole;
    }

    public void setLoopConsole(boolean loopConsole) {
        this.loopConsole = loopConsole;
    }

    public Console(InputStream inputStream, PrintStream outputStream) {
        scanner = new Scanner(inputStream);
        output = outputStream;
        loopConsole = true;
    }

    public Console() {
        this(System.in, System.out);
    }

    public void optionsMenu1() {
        System.out.println("Options in our menu: ");
        System.out.println();

        System.out.println("(1) addition");
        System.out.println("(2) subtraction");
        System.out.println("(3) multiplication");
        System.out.println("(4) division");
        System.out.println("(5) power");
        System.out.println("(6) square root");
        System.out.println("(q) quit");
    }

    public void startup() {
        System.out.println("This is " + APP_NAME + " version " + VERSION);
        String buffer;

        while (isLoopConsole()) {
            optionsMenu1();

            System.out.println();
            System.out.print(">>> ");
            buffer = scanner.nextLine();
            evaluateBufferForOptionsMenu1(buffer);
            System.out.println("==============================================");
        }
    }

    private void evaluateBufferForOptionsMenu1(String buffer) {
        double val1;
        double val2;
        switch(buffer) {
            case "1":
                val1 = getValidNumberFromUser("Enter your first number: ");
                val2 = getValidNumberFromUser("Enter your second number: ");

                System.out.println(val1 + " + " + val2 + " = " + Calculator.add(val1,val2).value());
                break;
            case "2":
                val1 = getValidNumberFromUser("Enter your first number: ");
                val2 = getValidNumberFromUser("Enter your second number: ");

                System.out.println(val1 + " - " + val2 + " = " + Calculator.subtract( val1,val2).value());
                break;
            case "3":
                val1 = getValidNumberFromUser("Enter your first number: ");
                val2 = getValidNumberFromUser("Enter your second number: ");

                System.out.println(val1 + " * " + val2 + " = " + Calculator.multiply( val1,val2).value());
                break;
            case "4":
                val1 = getValidNumberFromUser("Enter your first number: ");
                val2 = getValidNumberFromUser("Enter your second number: ");

                Result result = Calculator.divide(val1, val2);

                if (!result.valid()) {
                    System.out.println("Cannot divide " + val1 + " by 0");
                    break;
                }

                System.out.println(val1 + " / " + val2 + " = " + Calculator.divide( val1,val2).value());
                break;
            case "5":
                val1 = getValidNumberFromUser("Enter your base number: ");
                val2 = getValidNumberFromUser("Enter your number to the power of: ");

                System.out.println(val1 + " to the power of " + val2 + " = " + Calculator.power(val1, val2).value());
                break;
            case "6":
                val1 = getValidNumberFromUser("Enter your number: ");

                System.out.println("Square root of " + val1 + " = " + Calculator.squareRoot(val1).value());
                break;
            case "q":
                System.out.println("quit");
                setLoopConsole(false);
                break;
            default:
                System.out.println("Invalid option. Try again");
                break;
        }
    }

    private boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private double getValidNumberFromUser(String inputMessage) {
        System.out.println(inputMessage);
        System.out.print("\n>>> ");
        String buffer = scanner.nextLine();

        while (!isValidNumber(buffer)) {
            System.out.println("Invalid Numeric Value! Try again.");


            System.out.println(inputMessage);
            System.out.print("\n>>> ");
            buffer = scanner.nextLine();
        }

        return Double.parseDouble(buffer);
    }
}
