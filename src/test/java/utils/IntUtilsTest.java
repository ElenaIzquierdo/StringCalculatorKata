package utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntUtilsTest {
    @Nested
    class getIntegerFromString {
        @Test
        void shouldReturnNegativeNumber() {
            assertEquals(-23, IntUtils.getIntegerFrom("-23"));
        }

        @Test
        void shouldReturnPositiveNumber() {
            assertEquals(23, IntUtils.getIntegerFrom("23"));
        }
    }

    @Nested
    class getInteger {
        @Test
        void shouldReturnTheIntegerWenADigitIsReceived() {
            assertEquals(7, IntUtils.getIntegerFrom('7'));
        }
    }
}