package com.mortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(Number[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        try (Scanner scanner = new Scanner(System.in)) { // try-with-resources block
            System.out.print("Principle: ");
            int principle = scanner.nextInt();

            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEARS;

            System.out.print("Periods(Years): ");
            byte years = scanner.nextByte();
            int numberOfPayments = years * MONTHS_IN_YEARS;

            double mortgage = principle * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

            String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.println("Mortgage: " + formattedMortgage);
        }
    }
}
