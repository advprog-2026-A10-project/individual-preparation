package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

    public static double[] add(double[] vector1, double[] vector2) {
        if (vector1 == null || vector2 == null) {
            throw new IllegalArgumentException("Vectors must not be null.");
        }
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException(
                    "Vector size must match. Got: vector1=" + vector1.length +
                            ", vector2=" + vector2.length
            );
        }
        int n = vector1.length;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            double a = vector1[i];
            double b = vector2[i];
            if (!Double.isFinite(a)) {
                throw new IllegalArgumentException(
                        "vector1[" + i + "] must be finite."
                );
            }
            if (!Double.isFinite(b)) {
                throw new IllegalArgumentException(
                        "vector2[" + i + "] must be finite."
                );
            }
            double sum = a + b;
            if (!Double.isFinite(sum)) {
                throw new ArithmeticException(
                        "Overflow at index " + i
                );
            }
            result[i] = sum;
        }
        return result;
    }



    public double[] subtract(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double[] multiply(double[] v1, int x) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }
    
    public double dotProduct(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return 0.0;
    }
    
    public double norm(double[] v1) {
        // TODO: Implement me properly!
        return 0.0;
    }
}