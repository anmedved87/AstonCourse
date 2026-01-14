package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTest {
    ArithmeticOperations c = new ArithmeticOperations();

    @Test
    public void testAdd() {
        assertEquals(c.addition(3, 4), 7);
    }

    @Test
    public void testSubtract() {
        assertEquals(c.subtraction(5, 4), 1);
    }

    @Test
    public void testMultiply() {
        assertEquals(c.multiplic(4, 5), 20);
    }

    @Test
    public void testDivide() {
        assertEquals(c.division(10, 5), 2);
    }
}
