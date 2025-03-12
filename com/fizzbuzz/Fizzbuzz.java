package com.fizzbuzz;

import java.util.Scanner;

public class Fizzbuzz {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter number(To exit enter 0): ");
                int number = scanner.nextInt();

                if (number == 0)
                    break;

                if ((number % 5) == 0 && (number % 3) == 0)
                    System.out.println("FizzBuzz");
                else if ((number % 5) == 0)
                    System.out.println("Fizz");
                else if ((number % 3) == 0)
                    System.out.println("Buzz");
                else
                    System.out.println("Number: " + number);
            }
        }
    }
}
