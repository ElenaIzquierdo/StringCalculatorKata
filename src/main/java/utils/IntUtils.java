package utils;

import static java.lang.Integer.parseInt;

public class IntUtils {
    public static int getIntegerFrom(String numberAsString) {
        if(numberAsString.charAt(0) == '-') {
            return convertNumberString(numberAsString.length()-2, numberAsString.substring(1), 1) * -1;
        }
        return convertNumberString(numberAsString.length()-1, numberAsString, 1);
    }

    private static int convertNumberString(int i, String num, int mult) {
        char c = num.charAt(i);
        if(i == 0) return getIntegerFrom(c) * mult;
        else return getIntegerFrom(c) * mult + convertNumberString(i-1, num, mult*10);
    }

    public static int getIntegerFrom(char c) {
        return parseInt(String.valueOf(c));
    }

}
