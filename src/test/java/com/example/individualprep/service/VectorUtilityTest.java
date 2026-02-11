package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class VectorUtilityTest {

    private final VectorUtility vectorUtility = new VectorUtility();

    @Test
    public void testSubtractSuccess() {
        double[] v1 = { 5.0, 10.0, 15.0 };
        double[] v2 = { 2.0, 4.0, 6.0 };
        double[] expected = { 3.0, 6.0, 9.0 };

        double[] result = vectorUtility.subtract(v1, v2);

        assertArrayEquals(expected, result, 0.0001);
    }

    @Test
    public void testSubtractDifferentLengthVectors() {
        double[] v1 = { 1.0, 2.0 };
        double[] v2 = { 1.0, 2.0, 3.0 };

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(v1, v2);
        });

        assertEquals("Vektor harus memiliki panjang yang sama. ", exception.getMessage());
    }
}
