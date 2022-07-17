package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Square {

    //7 https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    @Test
    public void test() {
        assertFalse(Square.isSquare(-1));
        assertFalse(Square.isSquare(3));
        assertFalse(Square.isSquare(26));
        assertTrue(Square.isSquare(0));
        assertTrue(Square.isSquare(4));
        assertTrue(Square.isSquare(25));
    }
}
