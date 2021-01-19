package usecases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewStringCalculatorTest {

    private final NewStringCalculator stringCalculator = new NewStringCalculator();

    @Test
    void shouldReturn0WhenEmptyString() {
        int result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void shouldReturnTheSameNumberWhenStringWithOneNumber() {
        int result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void shouldReturnTheSumOfTheNumbersWhenStringContainsThem() {
        int result = stringCalculator.add("1,2,3,4");

        assertEquals(10, result);
    }

    @Test
    void shouldIgnoreNewLineAndSumNumbers() {
        int result = stringCalculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    void shouldIgnoreOtherDelimeters() {
        int result = stringCalculator.add("//;\\n1;2");

        assertEquals(3, result);
    }
}