package converters;

import utils.IntUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        return Arrays.stream(numbers
                .replaceAll("\n", delimiter)
                .split(delimiter))
                .map(IntUtils::getIntegerFrom)
                .collect(Collectors.toList());
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
