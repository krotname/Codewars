package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberFun {

    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if (sqrt % 1 != 0) return -1;
        return (long) Math.pow(++sqrt, 2);
    }

    @Test
    public void test() {
        assertEquals(144, findNextSquare(121));
        assertEquals(676, findNextSquare(625));
        assertEquals(-1, findNextSquare(114));
    }
}
