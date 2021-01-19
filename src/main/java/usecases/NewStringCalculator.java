package usecases;

import exceptions.NegativeNumberException;
import utils.CharUtils;
import utils.IntUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.CharUtils.isDigit;
import static utils.IntUtils.getNumberFromString;

public class NewStringCalculator {

    public int add(String numbers) throws NegativeNumberException {
        if(numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if(numbers.charAt(0) == '/') {
            delimiter = Character.toString(numbers.charAt(2));
        }
        String [] numbersSplitted = getSubstringToWork(numbers, delimiter);
        int count = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for(int i = 0; i < numbersSplitted.length; i++){
            int num = getNumberFromString(numbersSplitted[i]);
            if(num < 0) negativeNumbers.add(num);
            if(num > 1000) num = 0;
            count += num;
        }

        if(!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException(negativeNumbers);
        }
        return count;
    }

    private String [] getSubstringToWork(String numbers, String delimiter) {
        if(delimiter != ",") {
            numbers = numbers.substring(5);
        }
        String numbersWithoutNewLines = numbers.replaceAll("\n", delimiter);
        return numbersWithoutNewLines.split(delimiter);
    }
}
