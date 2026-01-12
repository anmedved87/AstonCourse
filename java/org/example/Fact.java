package org.example;

package lesson7;

public class Fact {

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be >= 0");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

