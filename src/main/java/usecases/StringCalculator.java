package usecases;

import static utils.CharUtils.getIntegerFrom;
import static utils.CharUtils.isDigit;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        for(int i =0; i < numbers.length(); ++i) {
            char c = numbers.charAt(i);
            if(isDigit(c)){
                result += getIntegerFrom(c);
            }
        }
        return result;
    }
}

