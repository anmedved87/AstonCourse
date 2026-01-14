package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AreaTriangleTest {
    @Test
    public void testArea() {
        AreaTriangle t = new AreaTriangle();
        assertEquals(t.area(4, 5), 10);
    }
}
