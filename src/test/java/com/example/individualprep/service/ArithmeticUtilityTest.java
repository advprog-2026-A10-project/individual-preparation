package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void multiplyReturnsProduct() {
        double result = arithmeticUtility.multiply(2.5, -4.0);
        assertEquals(-10.0, result, 1e-12);
    }

    @Test
    void multiplyRejectsNonFiniteO1() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arithmeticUtility.multiply(Double.NaN, 2.0)
        );

        assertEquals("o1 must be finite.", exception.getMessage());
    }

    @Test
    void multiplyRejectsNonFiniteO2() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> arithmeticUtility.multiply(2.0, Double.POSITIVE_INFINITY)
        );

        assertEquals("o2 must be finite.", exception.getMessage());
    }

    @Test
    void multiplyRejectsOverflow() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> arithmeticUtility.multiply(Double.MAX_VALUE, 2.0)
        );

        assertEquals("Overflow in multiplication.", exception.getMessage());
    }
}
