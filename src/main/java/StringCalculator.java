import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        for(int i =0; i < numbers.length(); i=i+2) {
            result += getIntegerFrom(numbers.charAt(i));
        }

        return result;
    }

    private int getIntegerFrom(char c) {
        return parseInt(String.valueOf(c));
    }

}

