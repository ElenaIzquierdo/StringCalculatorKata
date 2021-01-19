package converters;

import utils.IntUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStringNumbersToListIntNumbersConverter {

    public List<Integer> convertFrom(String numbers) {
        String delimiter = ",";
        if(numbers.charAt(0) == '/') {
            delimiter = Character.toString(numbers.charAt(2));
        }
        return getListOfNumbersAsIntToWork(numbers, delimiter);
    }

    private List<Integer> getListOfNumbersAsIntToWork(String numbers, String delimiter) {
        if(!delimiter.equals(",")) {
            numbers = numbers.substring(5);
        }
        String numbersWithoutNewLines = numbers.replaceAll("\n", delimiter);
        String [] numbersAsString = numbersWithoutNewLines.split(delimiter);

        List<Integer> result = new ArrayList<>();
        for(String number : numbersAsString) {
            int convertedNumber = IntUtils.getNumberFromString(number);
            result.add(convertedNumber);
        }

        return result;
    }
}
