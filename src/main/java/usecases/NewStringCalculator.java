package usecases;

import converters.NumbersConverter;
import exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewStringCalculator {

    private final NumbersConverter converter;

    public NewStringCalculator(NumbersConverter converter) {
        this.converter = converter;
    }

    public int add(String numbers) throws NegativeNumberException {
        if(numbers.isEmpty()) {
            return 0;
        }
        List<Integer> numbersSplitted = converter.convertFrom(numbers);
        List<Integer> negativeNumbers = numbersSplitted.stream().filter(num -> num < 0).collect(Collectors.toList());

        if(!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException(negativeNumbers);
        }

        return numbersSplitted.stream()
                .filter(num -> num <= 1000)
                .reduce(0, Integer::sum);
    }
}
