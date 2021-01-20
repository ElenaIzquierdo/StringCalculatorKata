package usecases;

import converters.NumbersConverter;
import exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> negativeNumbers = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < numbersSplitted.size(); i++){
            int num = numbersSplitted.get(i);
            if(num < 0) negativeNumbers.add(num);
            if(num > 1000) num = 0;
            count += num;
        }

        if(!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException(negativeNumbers);
        }
        return count;
    }
}
