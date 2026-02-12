package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
public class VectorUtilityTest {
    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    void multiplyReturnsElementWiseScalarProduct() {
        double[] v1 = new double[] { 1.5, -2.0, 3.25 };
        int x = 2;

        double[] result = vectorUtility.multiply(v1, x);

        assertArrayEquals(new double[] { 3.0, -4.0, 6.5 }, result, 1e-12);
    }

    @Test
    void multiplyAllowsNegativeScalar() {
        double[] v1 = new double[] { 1.5, -2.0, 3.25 };
        int x = -3;

        double[] result = vectorUtility.multiply(v1, x);

        assertArrayEquals(new double[] { -4.5, 6.0, -9.75 }, result, 1e-12);
    }

    @Test
    void multiplyRejectsNullVector() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> vectorUtility.multiply(null, 2)
        );

        assertEquals("Vector must not be null.", exception.getMessage());
    }

    @Test
    void multiplyRejectsNonFiniteValueInVector() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> vectorUtility.multiply(new double[] { Double.NaN }, 2)
        );

        assertEquals("vector1[0] must be finite.", exception.getMessage());
    }

    @Test
    void multiplyRejectsOverflow() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> vectorUtility.multiply(new double[] { Double.MAX_VALUE }, 2)
        );

        assertEquals("Overflow at index 0", exception.getMessage());
    }
}
