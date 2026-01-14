package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {
    @Test
    public void testFactorialPositive() {
        Factorial f = new Factorial();
        Assert.assertEquals(f.factorial(3), 6);
    }

    @Test
    public void testFactorialZero() {
        Factorial f = new Factorial();
        Assert.assertEquals(f.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Factorial f = new Factorial();
        f.factorial(-3);
    }
}
