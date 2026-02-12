package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorUtilityTest {

    @Test
    void example() {
        // TODO: Implement unit tests for VectorUtility methods
        assertEquals(0.0, 0.0, 1e-9);
    }
}

class VectorUtilityAddTest {

    @Test
    void addReturnsElementWiseSum() {
        double[] v1 = new double[] { 1.5, -2.0, 3.25 };
        double[] v2 = new double[] { 2.5, 2.0, -0.25 };

        double[] result = VectorUtility.add(v1, v2);

        assertArrayEquals(new double[] { 4.0, 0.0, 3.0 }, result, 1e-12);
    }

    @Test
    void addRejectsNullVectors() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> VectorUtility.add(null, new double[] { 1.0 })
        );

        assertEquals("Vectors must not be null.", exception.getMessage());
    }

    @Test
    void addRejectsMismatchedLengths() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> VectorUtility.add(new double[] { 1.0, 2.0 }, new double[] { 1.0 })
        );

        assertEquals("Vector size must match. Got: vector1=2, vector2=1", exception.getMessage());
    }

    @Test
    void addRejectsNonFiniteValueInFirstVector() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> VectorUtility.add(new double[] { Double.NaN }, new double[] { 1.0 })
        );

        assertEquals("vector1[0] must be finite.", exception.getMessage());
    }

    @Test
    void addRejectsNonFiniteValueInSecondVector() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> VectorUtility.add(new double[] { 1.0 }, new double[] { Double.POSITIVE_INFINITY })
        );

        assertEquals("vector2[0] must be finite.", exception.getMessage());
    }

    @Test
    void addRejectsOverflow() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> VectorUtility.add(new double[] { Double.MAX_VALUE }, new double[] { Double.MAX_VALUE })
        );

        assertEquals("Overflow at index 0", exception.getMessage());
    }
}

