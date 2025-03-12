package com.mortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        boolean isPrincipleEntered = false;
        boolean isInterestEntered = false;

        try (Scanner scanner = new Scanner(System.in)) { // try-with-resources block
            int principle = 0;
            float monthlyInterestRate = 0;

            while (true) {
                if (!isPrincipleEntered) {
                    System.out.print("Principle ($1K - $100K): ");
                    principle = scanner.nextInt();

                    if (principle < 1000 || principle > 100_000) {
                        warn("Principle amount must be between $1K TO $100K!");
                        continue;
                    }
                    isPrincipleEntered = true;
                }

                if (!isInterestEntered) {
                    System.out.print("Annual Interest Rate (1 - 30): ");
                    float annualInterestRate = scanner.nextFloat();

                    if (annualInterestRate < 1 || annualInterestRate > 30) {
                        warn("Annual interest rate to be between 1 TO 30!");
                        continue;
                    }
                    monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEARS;
                    isInterestEntered = true;
                }

                System.out.print("Period(Years)(1 - 30): ");
                byte years = scanner.nextByte();
                if (years < 1 || years > 30) {
                    warn("Period to be between 1 TO 30 years!");
                    continue;
                }
                int numberOfPayments = years * MONTHS_IN_YEARS;

                double mortgage = principle
                        * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                        / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

                String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
                System.out.println(GREEN + "Mortgage: " + formattedMortgage + RESET);
                break;
            }
        }
    }

    private static void warn(String text) {
        System.out.println(RED + "Warning: " + RESET + YELLOW + text + RESET);
    }
}
