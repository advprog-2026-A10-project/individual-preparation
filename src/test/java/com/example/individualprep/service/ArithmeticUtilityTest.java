package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticUtilityTest {

    private ArithmeticUtility arithmeticUtility;

    @BeforeEach
    void setUp() {
        arithmeticUtility = new ArithmeticUtility();
    }

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
