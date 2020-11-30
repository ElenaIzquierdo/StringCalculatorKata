import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        for(int i =0; i < numbers.length(); ++i) {
            char c = numbers.charAt(i);
            if(isDigit(c)){
                result += getIntegerFrom(c);
            }
        }

        return result;
    }

    private int getIntegerFrom(char c) {
        return parseInt(String.valueOf(c));
    }

    private boolean isDigit(char c) {
        return c > 47 && c < 58;
    }

}

