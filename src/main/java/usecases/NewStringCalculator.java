package usecases;

import utils.CharUtils;

import static utils.CharUtils.isDigit;

public class NewStringCalculator {

    public int add(String numbers){
        if(numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if(!isDigit(numbers.charAt(0))) {
            delimiter = Character.toString(numbers.charAt(2));
        }
        String [] numbersSplitted = getSubstringToWork(numbers, delimiter);
        int count = 0;
        for(int i = 0; i < numbersSplitted.length; i++){
            char c = numbersSplitted[i].charAt(0);
            count += CharUtils.getIntegerFrom(c);
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
