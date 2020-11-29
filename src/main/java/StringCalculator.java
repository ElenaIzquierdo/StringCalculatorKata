import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty() || numbers.length() > 3) {
            return 0;
        }

        if(numbers.length() == 3) {
            int firstNumber = getNumberFrom(numbers.charAt(0));
            int secondNumber = getNumberFrom(numbers.charAt(2));

            return firstNumber + secondNumber;
        }

        return parseInt(numbers);
    }

    private int getNumberFrom(char c) {
        return parseInt(String.valueOf(c));
    }

}

