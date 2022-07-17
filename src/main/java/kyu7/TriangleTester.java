package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTester {

    //7 https://www.codewars.com/kata/56606694ec01347ce800001b/train/java

    public static boolean isTriangle(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    @Test
    public void publicTests() {
        assertTrue(TriangleTester.isTriangle(1, 2, 2));
        assertFalse(TriangleTester.isTriangle(7, 2, 2));
    }
}
