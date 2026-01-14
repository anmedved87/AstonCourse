package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparisonTest {
    Comparison c = new Comparison();

    @Test
    public void testALargerB() {
        Assert.assertEquals(c.compare(10, 5), 1);
    }

    @Test
    public void testALessB() {
        Assert.assertEquals(c.compare(3, 7), -1);
    }

    @Test
    public void testAEquallyB() {
        Assert.assertEquals(c.compare(5, 5), 0);
    }
}

