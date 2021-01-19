package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntUtilsTest {

    @Test
    void shouldReturnNegativeNumber() {
        assertEquals(-23, IntUtils.getNumberFromString("-23"));
    }

    @Test
    void shouldReturnPositiveNumber() {
        assertEquals(23, IntUtils.getNumberFromString("23"));
    }
}