package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinMax {

    public static int[] minMax(int[] arr) {
        int[] r = new int[2];
        r[0] = Integer.MAX_VALUE;
        r[1] = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j < r[0]) {
                r[0] = j;
            }
            if (j > r[1]) {
                r[1] = j;
            }
        }
        return r;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1, 5}, minMax(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{5, 2334454}, minMax(new int[]{2334454, 5}));
    }
}
