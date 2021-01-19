package exceptions;

public class NegativeNumberException extends Exception {
    public NegativeNumberException(String[] numbers) {
        super("negatives not allowed " + numbers);
    }
}
