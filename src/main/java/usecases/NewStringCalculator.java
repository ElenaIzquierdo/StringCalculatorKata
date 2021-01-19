package usecases;

import utils.CharUtils;
public class NewStringCalculator {

    public int add(String numbers){
        if(numbers.isEmpty()) {
            return 0;
        }
        String numbersWithoutNewLines = numbers.replaceAll("\n", ",");
        String [] numbersSplitted = numbersWithoutNewLines.split(",");
        int count = 0;
        for(int i = 0; i < numbersSplitted.length; i++){
            char c = numbersSplitted[i].charAt(0);
            count += CharUtils.getIntegerFrom(c);
        }

        return count;
    }
}
