package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ComparisonTest {

    Comparison n = new Comparison();

    @Test
    public void testCompare() {
        assertEquals(n.compare(5, 5), 0);
    }
}

