package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorUtilityTest {

    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = new VectorUtility();
    }

    @Test
    void testDotProductSuccess() {
        double[] v1 = {1.0, 3.0, -5.0};
        double[] v2 = {4.0, -2.0, -1.0};
        assertEquals(3.0, vectorUtility.dotProduct(v1, v2));
    }

    @Test
    void testDotProductLengthMismatch() {
        double[] v1 = {1.0, 2.0};
        double[] v2 = {1.0, 2.0, 3.0};
        assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));

    @Test
    void testNormOfZeroVector() {
        double[] v = {0.0, 0.0, 0.0};
        assertEquals(0.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOfUnitVectorX() {
        double[] v = {1.0, 0.0, 0.0};
        assertEquals(1.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOfUnitVectorY() {
        double[] v = {0.0, 1.0, 0.0};
        assertEquals(1.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOfUnitVectorZ() {
        double[] v = {0.0, 0.0, 1.0};
        assertEquals(1.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOfSimpleVector() {
        double[] v = {3.0, 4.0};
        assertEquals(5.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOf3DVector() {
        double[] v = {1.0, 2.0, 3.0};
        assertEquals(Math.sqrt(14.0), vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormWithNegativeComponents() {
        double[] v = {-3.0, -4.0};
        assertEquals(5.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormWithMixedSignComponents() {
        double[] v = {-3.0, 4.0};
        assertEquals(5.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOfSingleElementVector() {
        double[] v = {5.0};
        assertEquals(5.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormOfSingleNegativeElementVector() {
        double[] v = {-7.0};
        assertEquals(7.0, vectorUtility.norm(v), 1e-9);
    }

    @Test
    void testNormIsAlwaysNonNegative() {
        double[] v = {-1.0, -2.0, -3.0};
        assertTrue(vectorUtility.norm(v) >= 0.0);
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

