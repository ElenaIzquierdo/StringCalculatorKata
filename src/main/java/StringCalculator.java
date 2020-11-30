import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        int result = 0;
        for(int i =0; i < numbers.length(); ++i) {
            char c = numbers.charAt(i);
            if(c != '\\' && c!=','){
                result += getIntegerFrom(c);
            }else if(c == '\\'){
                ++i;
            }
        }

        return result;
    }

    private int getIntegerFrom(char c) {
        return parseInt(String.valueOf(c));
    }

}

