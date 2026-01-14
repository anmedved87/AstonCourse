package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparisonTest {
    @Test
    void testALargerB() {
        Comparison c = new Comparison();
        Assertions.assertEquals(1, c.compare(10, 2));
    }


    @Test
    void testALessB() {
        Comparison c = new Comparison();
        Assertions.assertEquals(-1, c.compare(3, 10));
    }

    @Test
    void testAEquallyB() {
        Comparison c = new Comparison();
        Assertions.assertEquals(0, c.compare(4, 4));
    }
}
