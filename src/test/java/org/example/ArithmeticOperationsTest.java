package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticOperationsTest {
    ArithmeticOperations a = new ArithmeticOperations();

    @Test
    public void testAddition() {
        assertEquals(a.addition(3, 3), 6);
    }

    @Test
    public void testSubtraction() {
        assertEquals(a.subtraction(8, 3), 5);
    }

    @Test
    public void testMultiplc() {
        assertEquals(a.multiplic(9, 6), 54);
    }

    @Test
    public void testDivision() {
        assertEquals(a.division(10, 5), 2);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionZero() {
        a.division(3, 0);
    }

}
