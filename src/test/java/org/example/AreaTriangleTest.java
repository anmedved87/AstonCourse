package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AreaTriangleTest {
    @Test
    void testArea() {
        AreaTriangle t = new AreaTriangle();
        Assertions.assertEquals(40, t.area(8, 10));
    }

    @Test
    void testInvalidValues() {
        AreaTriangle t = new AreaTriangle();
        Assertions.assertThrows(IllegalArgumentException.class, () -> t.area(8, -10));
    }
}
