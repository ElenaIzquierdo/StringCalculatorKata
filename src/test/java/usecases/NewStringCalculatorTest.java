package usecases;

import converters.NumbersConverter;
import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NewStringCalculatorTest {

    private final NumbersConverter converter = mock(NumbersConverter.class);

    private final NewStringCalculator stringCalculator = new NewStringCalculator(converter);

    @Test
    void shouldReturn0WhenEmptyString() throws NegativeNumberException {
        int result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void shouldReturnTheSameNumberWhenStringWithOneNumber() throws NegativeNumberException {
        when(converter.convertFrom("1")).thenReturn(List.of(1));
        int result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void shouldReturnTheSumOfTheNumbersWhenStringContainsThem() throws NegativeNumberException {
        when(converter.convertFrom("1,2,3,4")).thenReturn(List.of(1,2,3,4));
        int result = stringCalculator.add("1,2,3,4");

        assertEquals(10, result);
    }

    @Test
    void shouldNotAcceptNegatives() {
        when(converter.convertFrom("-1,-2,3,1")).thenReturn(List.of(-1,-2,3,1));
        Exception exception = assertThrows(NegativeNumberException.class, () -> {
            stringCalculator.add("-1,-2,3,1");
        });

        String expectedMessage = "negatives not allowed [-1, -2]";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldIgnoreNumbersBiggerThan1000() throws NegativeNumberException {
        when(converter.convertFrom("2,1001")).thenReturn(List.of(2,1001));
        int result = stringCalculator.add("2,1001");

        assertEquals(2, result);
    }
}