package converters;

import utils.IntUtils;

import java.util.ArrayList;
import java.util.List;

public class NumbersConverter {

    public List<Integer> convertFrom(String numbers) {
        String delimiter = ",";
        if(numbers.charAt(0) == '/') {
            delimiter = getDelimeter(numbers);
        }
        return getListOfNumbersAsInt(numbers, delimiter);
    }

    private List<Integer> getListOfNumbersAsInt(String numbers, String delimiter) {
        if(!delimiter.equals(",")) {
            numbers = numbers.substring(6 + delimiter.length()/2);
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

    private String getDelimeter(String numbers) {
        int i = 3;
        char c = numbers.charAt(i);
        String delimiter = "";
        while(c != ']') {
            delimiter =delimiter + "\\" + c ;
            ++i;
            c = numbers.charAt(i);
        }
        return delimiter;
    }
}
