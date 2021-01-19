package exceptions;

import java.util.List;

public class NegativeNumberException extends Exception {
    public NegativeNumberException(List<Integer> numbers) {
        super("negatives not allowed " + numbers);
    }
}
