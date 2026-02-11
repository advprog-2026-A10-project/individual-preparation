package com.example.individualprep.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    public void testDivideSuccess() {
        double result = arithmeticUtility.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            arithmeticUtility.divide(10.0, 0.0);
        });
        assertEquals("Pembagian oleh nol tidak bisa dilakukan. ", exception.getMessage());
    }
}
