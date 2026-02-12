package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArithmeticUtilityTest {

    private ArithmeticUtility arithmeticUtility;
  
    @Test
    void testSubtractSuccess() {
        double result = arithmeticUtility.subtract(10.0, 7.0);
        assertEquals(3.0, result);
    

    @BeforeEach
    void setUp() {
        arithmeticUtility = new ArithmeticUtility();
    }

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

    @Test
    void testAddTwoPositiveNumbers() {
        assertEquals(6.0, arithmeticUtility.add(2.5, 3.5), 1e-9);
    }

    @Test
    void testAddPositiveAndNegative() {
        assertEquals(2.0, arithmeticUtility.add(5.0, -3.0), 1e-9);
    }

    @Test
    void testAddWithZero() {
        assertEquals(7.0, arithmeticUtility.add(7.0, 0.0), 1e-9);
    }

    @Test
    void testAddDecimals() {
        // floating point addition; allow small epsilon
        assertEquals(0.3, arithmeticUtility.add(0.1, 0.2), 1e-9);
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5.5, arithmeticUtility.add(-2.5, -3.0), 1e-9);
    }
}


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
