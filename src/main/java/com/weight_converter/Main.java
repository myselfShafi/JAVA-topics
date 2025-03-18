package com.weight_converter;

import java.util.Scanner;

import utils.ConsoleColors;

public class Main {
    final static double POUND_TO_KG = 0.453592;
    final static double KG_TO_POUND = 2.20462;

    static Scanner scanner = new Scanner(System.in);

    static double weight;
    static int option;
    static String unit;
    static String conversionUnit;

    public static void main(String[] args) {

        while (true) {
            ConsoleColors.printlnCustom(
                    "Choose your conversion option(Enter option number): \n 1. Pound to kg(s)    2. Kg to Pound(lbs)");

            option = scanner.nextInt();
            if (option != 1 && option != 2) {
                ConsoleColors.printlnCustom(" Warning: Please enter a valid option number! ", "RED_TEXT",
                        "YELLOW_BG");
                continue;
            }
            unit = option == 1 ? "pound(lbs): " : "kg(s): ";
            conversionUnit = option == 1 ? "kg(s): " : "pound(lbs): ";

            ConsoleColors.printCustom("Enter your weight in " + unit);
            weight = scanner.nextDouble();
            weight *= option == 1 ? POUND_TO_KG : KG_TO_POUND;

            ConsoleColors.printfCustom("Your weight in " + conversionUnit + "%.2f", "WHITE_TEXT",
                    "BLUE_BG", weight);
            scanner.close();
            break;
        }
    }
}