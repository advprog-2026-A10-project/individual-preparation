package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {
    
    public double[] add(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double[] subtract(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double[] multiply(double[] v1, int x) {
        if (v1 == null) {
            throw new IllegalArgumentException("Vector must not be null.");
        }

        int n = v1.length;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            double a = v1[i];

            if (!Double.isFinite(a)) {
                throw new IllegalArgumentException("vector1[" + i + "] must be finite.");
            }

            double product = a * x;

            if (!Double.isFinite(product)) {
                throw new ArithmeticException("Overflow at index " + i);
            }

            result[i] = product;
        }

        return result;
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