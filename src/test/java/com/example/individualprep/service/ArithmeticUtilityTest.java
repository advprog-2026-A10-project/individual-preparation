package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticUtilityTest {

    private final ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

    @Test
    void testSubtractSuccess() {
        double result = arithmeticUtility.subtract(10.0, 7.0);
        assertEquals(3.0, result);
    }
}
