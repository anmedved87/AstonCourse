package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticOperationsTest {
    ArithmeticOperations a = new ArithmeticOperations();

    @Test
    void testAddition() {
        Assertions.assertEquals(5, a.addition(2, 3));
    }


    @Test
    void testSubtraction() {
        Assertions.assertEquals(5, a.subtraction(8, 3));
    }

    @Test
    void testMultiplc() {
        Assertions.assertEquals(54, a.multiplic(9, 6));
    }

    @Test
    void testDivision() {
        Assertions.assertEquals(6, a.division(30, 5));
    }

    @Test
    void testDivisionZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> a.division(30, 0));
    }

}
