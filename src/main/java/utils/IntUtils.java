package utils;

import static java.lang.Integer.parseInt;

public class IntUtils {
    public static int getIntegerFrom(String numberAsString) {
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

    public static int getIntegerFrom(char c) {
        return parseInt(String.valueOf(c));
    }

}
