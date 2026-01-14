package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaTriangleTest {
    @Test
    public void testArea() {
        AreaTriangle t = new AreaTriangle();
        Assert.assertEquals(t.area(8, 10), 40);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalid() {
        AreaTriangle t = new AreaTriangle();
        t.area(-10, 8);
    }
}
