import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

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
    void shouldIgnoreBackSlashNAndSumNumbers() {
        int result = stringCalculator.add("1\\n2,3");

        assertEquals(6, result);
    }
}