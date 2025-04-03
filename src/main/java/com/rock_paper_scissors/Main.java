package com.rock_paper_scissors;

import java.util.Random;
import java.util.Scanner;

import utils.ConsoleColors;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    final static String rock = "Rock";
    final static String paper = "Paper";
    final static String scissor = "Scissor";

    static boolean gameOver = false;
    static int score1 = 0;
    static int score2 = 0;

    public static void main(String[] args) {
        int option;
        while (!gameOver) {
            ConsoleColors.printlnCustom("Choose your selection: \n 1. Rock       2. Paper        3. Scissor");
            option = scanner.nextInt();
            if (option != 1 && option != 2 && option != 3) {
                ConsoleColors.printlnCustom(" Invalid Option! ", "RED_TEXT", "YELLOW_BG");
                continue;
            }

            int systemOption = random.nextInt(1, 4);
            ConsoleColors
                    .printlnCustom(
                            "You choose: " + selection(option) + "    Computer choice: " + selection(systemOption));
            displayScore(option, systemOption);
            if (gameOver) {
                break;
            }
        }
        ;
    }

    private static void displayScore(int option, int systemOption) {

        if (option == systemOption) {
            ConsoleColors.printlnCustom(" DRAW ", "WHITE_TEXT", "BLUE_BG");
        } else if ((option == 1 && systemOption == 2) || (option == 2 && systemOption == 3)
                || (option == 3 && systemOption == 1)) {
            score2++;
            ConsoleColors.printlnCustom(" YOU LOSE THIS ROUND ", "WHITE_TEXT", "YELLOW_BG");
        } else {
            score1++;
            ConsoleColors.printlnCustom(" YOU WIN THIS ROUND ", "WHITE_TEXT", "GREEN_BG");
        }
        ConsoleColors.printCustom(" Current Score ", "WHITE_TEXT", "PURPLE_BG");
        ConsoleColors.printlnCustom(" " + score1 + " - " + score2, "PURPLE_TEXT");

        if (score1 == 3 || score2 == 3) {
            gameOver = true;
            ConsoleColors.printlnCustom("----- " + (score1 == 3 ? "Congrats! You" : "Computer") + " won -----",
                    score1 == 3 ? "GREEN_TEXT" : "RED_TEXT");
        }
    }

    private static String selection(int option) {
        switch (option) {
            case 1:
                return rock;
            case 2:
                return paper;
            case 3:
                return scissor;
            default:
                return "Invalid selection!";
        }
    }
}
