package usecases;

import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewStringCalculatorTest {

    private final NewStringCalculator stringCalculator = new NewStringCalculator();

    @Test
    void shouldReturn0WhenEmptyString() throws NegativeNumberException {
        int result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void shouldReturnTheSameNumberWhenStringWithOneNumber() throws NegativeNumberException {
        int result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void shouldReturnTheSumOfTheNumbersWhenStringContainsThem() throws NegativeNumberException {
        int result = stringCalculator.add("1,2,3,4");

        assertEquals(10, result);
    }

    @Test
    void shouldIgnoreNewLineAndSumNumbers() throws NegativeNumberException {
        int result = stringCalculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    void shouldAcceptOtherDelimeters() throws NegativeNumberException {
        int result = stringCalculator.add("//;\\n1;2");

        assertEquals(3, result);
    }

    @Test
    void shouldNotAcceptNegatives() {
        Exception exception = assertThrows(NegativeNumberException.class, () -> {
            stringCalculator.add("-1,-2,3,1");
        });

        String expectedMessage = "negatives not allowed [-1, -2]";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldIgnoreNumbersBiggerThan1000() throws NegativeNumberException {
        int result = stringCalculator.add("2,1001");

        assertEquals(2, result);
    }
}