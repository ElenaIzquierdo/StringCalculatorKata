package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharUtilsTest {

    private CharUtils charUtils;

    @BeforeEach
    void setUp() {
        charUtils = new CharUtils();
    }

    @Nested
    class isADigit {
        @Test
        void shouldReturnFalseWhenIsNotADigit() {
            assertFalse(charUtils.isDigit(','));
        }

        @Test
        void shouldReturnTrueWhenIsADigit() {
            assertTrue(charUtils.isDigit('7'));
        }
    }

    @Nested
    class getInteger {
        @Test
        void shouldReturnTheIntegerWenADigitIsReceived() {
            assertEquals(7, charUtils.getIntegerFrom('7'));
        }
    }
}