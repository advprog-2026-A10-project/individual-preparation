package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class VectorUtility {

    public double[] add(double[] v1, double[] v2) {
        // TODO: Implement me properly!
        return new double[] { 0.0, 0.0, 0.0 };
    }

    public double[] subtract(double[] v1, double[] v2) {
        try {
            if (v1.length != v2.length) {
                throw new IllegalArgumentException();
            }
            double[] result = new double[v1.length];
            for (int i = 0; i < v1.length; i++) {
                result[i] = v1[i] - v2[i];
            }
            return result;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Vektor harus memiliki panjang yang sama. ");
        }
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