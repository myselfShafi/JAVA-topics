package com.fizzbuzz;

import java.util.Scanner;

public class Fizzbuzz {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter number: ");
            int number = scanner.nextInt();

            if ((number % 5) == 0)
                System.out.println("Fizz");
            else if ((number % 3) == 0)
                System.out.println("Buzz");
            else
                System.out.println(number);
        }
    }
}
