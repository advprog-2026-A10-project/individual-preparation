package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtility {
    
    public double add(double o1, double o2) {
        return o1 + o2;
    }

    public double subtract(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double multiply(double o1, double o2) {
        if (!Double.isFinite(o1)) {
            throw new IllegalArgumentException("o1 must be finite.");
        }
        if (!Double.isFinite(o2)) {
            throw new IllegalArgumentException("o2 must be finite.");
        }

        double product = o1 * o2;

        if (!Double.isFinite(product)) {
            throw new ArithmeticException("Overflow in multiplication.");
        }

        return product;
    }

    public double divide(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double exponent(double base, int exp) {
        if (!Double.isFinite(base)) {
            throw new IllegalArgumentException("Base must be a finite number (not NaN/Infinity).");
        }

        double result = Math.pow(base, exp);

        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Result is not finite (overflow/underflow/invalid).");
        }

        return result;

    }
}
