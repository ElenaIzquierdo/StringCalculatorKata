package usecases;

import utils.CharUtils;

import java.util.Arrays;

public class NewStringCalculator {

    public int add(String numbers){
        if(numbers.isEmpty()) {
            return 0;
        }
        String [] numbersSplitted = numbers.split(",");
        int count = 0;
        for(int i = 0; i < numbersSplitted.length; i++){
            char c = numbersSplitted[i].charAt(0);
            count += CharUtils.getIntegerFrom(c);
        }

        return count;
    }
}
