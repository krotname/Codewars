package kyu7;

import java.util.Arrays;

public class MinMax {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minMax(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(minMax(new int[]{2334454, 5})));
    }

    public static int[] minMax(int[] arr) {
        int[] r = new int[2];
        r[0] = Integer.MAX_VALUE;
        r[1] = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < r[0]) {
                r[0] = arr[i];
            }
            if (arr[i] > r[1]) {
                r[1] = arr[i];
            }
        }
        return r;
    }
}
