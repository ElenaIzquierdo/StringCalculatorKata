package utils;

import static utils.CharUtils.getIntegerFrom;

public class IntUtils {
    public static int getNumberFromString(String numberAsString) {
        int number = 0;
        int mult = 1;
        for(int i = numberAsString.length() - 1; i >= 0; --i) {
            char c = numberAsString.charAt(i);
            if(c != '-') {
                number += getIntegerFrom(c) * mult;
                mult *= 10;
            }
            else {
                number *= -1;
            }
        }
        return number;
    }

}
