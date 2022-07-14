package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinMax {

    @Test
    public void test() {
        System.out.println(Arrays.toString(minMax(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(minMax(new int[]{2334454, 5})));
    }

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
}
