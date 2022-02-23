package grokking_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionMax {
    public static void main(String[] args) {
        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(19, 2, 4, 5, 4));
        System.out.println(recursionMax(integers1));
    }

    public static Integer recursionMax(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        if (array.isEmpty()) {
            return -1;
        }
        if (array.size() == 1) {
            return array.get(0);
        }
        if (array.size() == 2) {
            return Math.max(array.get(0), array.get(1));
        }
        int min = Math.min(array.get(0), array.get(1));
        array.remove((Integer) min);
        return recursionMax(array);
    }

    public static Integer max(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        if (array.isEmpty()) {
            return -1;
        }
        if (array.size() == 1) {
            return array.get(0);
        }
        int max = Integer.MIN_VALUE;
        for (int a : array
        ) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
