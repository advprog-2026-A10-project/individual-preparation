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
