package com.kevinhe99;

import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Console {
    public static final String APP_NAME = "Number Guessing Game";
    public static final String VERSION = "0.1.250806a";

    private final Scanner scanner;
    private boolean loopConsole;

    public boolean isLoopConsole() {
        return loopConsole;
    }

    public void setLoopConsole(boolean loopConsole) {
        this.loopConsole = loopConsole;
    }

    public Console(InputStream inputStream) {
        scanner = new Scanner(inputStream);
        loopConsole = true;
    }

    public Console() {
        this(System.in);
    }

    private void optionsMenu1() {
        System.out.println("Options in our menu: ");
        System.out.println();

        System.out.println("(1) play");
        System.out.println("(q) quit");
    }

    private void evaluateBufferForOptionsMenu1(String buffer) {
        switch(buffer) {
            case "1":
                System.out.println("Difficulty:");

                int userInput = getValidNumberFromUser("Max digits in your number (3 - 8):");

                while (userInput > 8 || userInput < 3) {
                    System.out.println("Number must be between 3 and 8 (inclusive)");
                    System.out.println("==============================================");

                    userInput = getValidNumberFromUser("Max digits in your number (3 - 8):");
            }


                int randomNumber = ThreadLocalRandom.current()
                        .nextInt(1, (int) Math.pow(10, userInput-1) + 1);

                ///////
                int higher = (int) Math.pow(10, userInput-1);
                int lower = 1;
                int userGuess = getValidNumberFromUser("Your number is between " + lower + " and " + higher + " (inclusive). Your next number is: ");
                int count = 0;

                while (userGuess != randomNumber) {
                    if (userGuess == higher || userGuess == lower) {
                        System.out.println("You already guessed this number!");
                    }else if (userGuess > higher) {
                        System.out.println("Your number is too high. Must stay within range.");
                    }else if (userGuess < lower) {
                        System.out.println("Your number is too low. Must stay within range.");
                    }else if (userGuess > randomNumber) {
                        higher = userGuess;
                        System.out.println("Your number is lower!");
                    }else {
                        lower = userGuess;
                        System.out.println("Your number is higher!");
                    }
                    System.out.println("==============================================");
                    userGuess = getValidNumberFromUser("Your number is between " + lower + " and " + higher + " (inclusive). Your next number is: ");
                    count += 1;
                }

                System.out.println("You got it! Your number was: " + randomNumber);
                System.out.println("You did it in " + count + " tries!");


                break;
            case "q":
                System.out.println("You have exited the program!");
                setLoopConsole(false);
                break;
            default:
                System.out.println("Invalid option. Try again");
                break;
        }
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

    private boolean isValidNumber(String number) {
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private int getValidNumberFromUser(String inputMessage) {
        System.out.println(inputMessage);
        System.out.print("\n>>> ");
        String buffer = scanner.nextLine();

        while (!isValidNumber(buffer)) {
            System.out.println("Invalid Numeric Value! Try again.");


            System.out.println(inputMessage);
            System.out.print("\n>>> ");
            buffer = scanner.nextLine();
        }

        return Integer.parseInt(buffer);
    }
}
