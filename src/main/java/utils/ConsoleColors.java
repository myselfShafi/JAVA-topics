package utils;

import java.util.HashMap;
import java.util.Map;

public class ConsoleColors {
    // Reset
    public static final String RESET = "\u001B[0m";

    private static final Map<String, String> COLORS = new HashMap<>();

    static {
        // Background Colors
        COLORS.put("BLACK_BG", "\u001B[40m");
        COLORS.put("RED_BG", "\u001B[41m");
        COLORS.put("GREEN_BG", "\u001B[42m");
        COLORS.put("YELLOW_BG", "\u001B[43m");
        COLORS.put("BLUE_BG", "\u001B[44m");
        COLORS.put("PURPLE_BG", "\u001B[45m");
        COLORS.put("CYAN_BG", "\u001B[46m");
        COLORS.put("WHITE_BG", "\u001B[47m");

        // Text Colors
        COLORS.put("BLACK_TEXT", "\u001B[30m");
        COLORS.put("RED_TEXT", "\u001B[31m");
        COLORS.put("GREEN_TEXT", "\u001B[32m");
        COLORS.put("YELLOW_TEXT", "\u001B[33m");
        COLORS.put("BLUE_TEXT", "\u001B[34m");
        COLORS.put("PURPLE_TEXT", "\u001B[35m");
        COLORS.put("CYAN_TEXT", "\u001B[36m");
        COLORS.put("WHITE_TEXT", "\u001B[37m");
    }

    public static String getColor(String colorKey) {
        return COLORS.getOrDefault(colorKey, RESET);
    }

    public static void printlnCustom(String message, String textColor, String bgColor) {
        System.out.println(getColor(bgColor) + getColor(textColor) + message + RESET);
    }

    public static void printlnCustom(String message, String textColor) {
        printlnCustom(message, textColor, RESET);
    }

    public static void printlnCustom(String message) {
        printlnCustom(message, "WHITE_TEXT");
    }

    public static void printCustom(String message, String textColor, String bgColor) {
        System.out.print(getColor(bgColor) + getColor(textColor) + message + RESET);
    }

    public static void printCustom(String message, String textColor) {
        printCustom(message, textColor, RESET);
    }

    public static void printCustom(String message) {
        printCustom(message, "WHITE_TEXT");
    }

    public static void printfCustom(String message, String textColor, String bgColor, Object... args) {
        System.out.printf(getColor(bgColor) + getColor(textColor) + message + RESET, args);
    }

    public static void printfCustom(String message, String textColor, Object... args) {
        printfCustom(message, textColor, RESET, args);
    }

    public static void printfCustom(String message, Object... args) {
        printfCustom(message, "WHITE_TEXT", args);
    }
    // two versions of printlnCustom(), printCustom(), overloaded method concept
}
