package utils;

import static java.lang.Integer.parseInt;

public class CharUtils {
    public static boolean isDigit(char c) {
        return c > 47 && c < 58;
    }

    public static int getIntegerFrom(char c) {
        return parseInt(String.valueOf(c));
    }
}
