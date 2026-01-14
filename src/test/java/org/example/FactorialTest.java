package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    @Test
    void testFactorialPositive() {
        Factorial f = new Factorial();
        Assertions.assertEquals(6, f.factorial(3));
    }

    @Test
    void testFactorialZero() {
        Factorial f = new Factorial();
        Assertions.assertEquals(1, f.factorial(0));
    }


    @Test
    void testFactorialNegative() {
        Factorial f = new Factorial();
        Assertions.assertThrows(IllegalArgumentException.class, () -> f.factorial(-3));
    }

}
