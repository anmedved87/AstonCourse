package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {
    @Test
    public void testFactorial() {
        Factorial f = new Factorial();
        assertEquals(f.factorial(5), 120);
    }
}
