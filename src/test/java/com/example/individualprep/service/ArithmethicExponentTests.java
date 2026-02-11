package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArithmethicExponentTests {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void exponentReturnsExpectedResultForPositiveExponent() {
        double result = arithmeticUtility.exponent(2.0, 3);

        assertEquals(8.0, result, 1e-12);
    }

    @Test
    void exponentReturnsOneWhenExponentIsZero() {
        double result = arithmeticUtility.exponent(5.75, 0);

        assertEquals(1.0, result, 1e-12);
    }

    @Test
    void exponentHandlesNegativeBaseWithOddExponent() {
        double result = arithmeticUtility.exponent(-2.0, 3);

        assertEquals(-8.0, result, 1e-12);
    }

    @Test
    void exponentRejectsNaNBase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arithmeticUtility.exponent(Double.NaN, 2)
        );

        assertEquals("Base must be a finite number (not NaN/Infinity).", exception.getMessage());
    }

    @Test
    void exponentRejectsInfiniteBase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arithmeticUtility.exponent(Double.POSITIVE_INFINITY, 2)
        );

        assertEquals("Base must be a finite number (not NaN/Infinity).", exception.getMessage());
    }

    @Test
    void exponentRejectsOverflowResult() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> arithmeticUtility.exponent(Double.MAX_VALUE, 2)
        );

        assertEquals("Result is not finite (overflow/underflow/invalid).", exception.getMessage());
    }
}
