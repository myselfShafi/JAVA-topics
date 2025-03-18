package com.fizzbuzz;

import java.util.Scanner;

import utils.ConsoleColors;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                ConsoleColors.printlnCustom("Enter number(To exit enter 0): ", "PURPLE_TEXT");
                int number = scanner.nextInt();

                if (number == 0) {
                    ConsoleColors.printlnCustom(" Exited Successfully! ", "CYAN_TEXT",
                            "BLUE_BG");
                    break;
                }

                if ((number % 5) == 0 && (number % 3) == 0)
                    ConsoleColors.printlnCustom("FizzBuzz", "CYAN_TEXT");
                else if ((number % 5) == 0)
                    ConsoleColors.printlnCustom("Fizz", "CYAN_TEXT");
                else if ((number % 3) == 0)
                    ConsoleColors.printlnCustom("Buzz", "CYAN_TEXT");
                else
                    ConsoleColors.printlnCustom("Number: " + number, "YELLOW_TEXT");
            }
        }
    }
}
