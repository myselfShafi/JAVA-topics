package com.banking_program;

import java.text.NumberFormat;
import java.util.Scanner;

import utils.ConsoleColors;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Double balance = 250.00;

    public static void main(String[] args) throws InterruptedException {
        ConsoleColors.printlnCustom("::: Welcome to JAVA Bank ::: ", "WHITE_TEXT", "BLUE_BG");

        Loader("Loading your balance");
        String balanceInInr = getCurrencyAmount(balance);
        ConsoleColors.printlnCustom("Your current balance: " + balanceInInr, "GREEN_TEXT");
        while (true) {
            ConsoleColors.printlnCustom("Choose your mode of transaction \n 1. Deposit    2. Withdrawal",
                    "PURPLE_TEXT");

            int option = scanner.nextInt();
            if (option != 1 && option != 2) {
                ConsoleColors.printlnCustom(" Warning: Please enter a valid option number! ", "RED_TEXT",
                        "YELLOW_BG");
                continue;
            }
            processTransaction(option);
            break;
        }
        scanner.close();
    }

    private static void Loader(String text) throws InterruptedException {
        int count = 3;
        while (count > 0) {
            count--;
            for (int i = 1; i <= 3; i++) {
                Thread.sleep(500);
                ConsoleColors.printCustom("\r" + text + " .".repeat(i) + " ", "YELLOW_TEXT");
            }
        }
        ;
        ConsoleColors.printlnCustom(""); // to skip to new line
    }

    private static void processTransaction(int option) throws InterruptedException {
        String success;
        double amount;

        while (true) {
            ConsoleColors.printCustom("Enter amount: ");
            amount = scanner.nextDouble();
            String amountInInr = getCurrencyAmount(balance);

            Loader(option == 1 ? "Depositing amount" : "Withdrawing amount");

            if (option == 2 && amount > balance) {
                ConsoleColors.printlnCustom("You don't have enough balance to withdraw " + amountInInr + "! Try again.",
                        "RED_TEXT");
                continue;
            }
            break;
        }

        if (option == 1) {
            balance += amount;
            success = "Amount successfully deposited!";
        } else {
            balance -= amount;
            success = "Withdrawal successful!";
        }
        String balanceInInr = getCurrencyAmount(balance);
        ConsoleColors.printlnCustom(success + " Updated balance: " + balanceInInr, "CYAN_TEXT", "GREEN_BG");
    }

    private static String getCurrencyAmount(Double amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }
}