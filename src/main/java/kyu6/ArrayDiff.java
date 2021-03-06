package kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ArrayDiff {

    //6 https://www.codewars.com/kata/523f5d21c841566fde000009

    public static int[] arrayDiff(int[] a, int[] b) {
        return Arrays.stream(a)
                .filter(valueA -> Arrays.stream(b)
                        .noneMatch(valueB -> valueA == valueB))
                .toArray();
    }

    public static int[] arrayDiffImperative(int[] a, int[] b) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : a
        ) {
            boolean ex = false;
            for (int j : b
            ) {
                if (i == j) {
                    ex = true;
                    break;
                }
            }
            if (!ex) {
                integers.add(i);
            }
        }

        return integers.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Your goal in this kata is to implement a difference function, which subtracts one
     * list from another and returns the result.
     * <p>
     * It should remove all values from list a, which are present in list b keeping their order.
     * <p>
     * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
     * If a value is present in b, all of its occurrences must be removed from the other:
     * <p>
     * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
     */

    @Test
    public void arrayDiffTest() {
        assertArrayEquals(arrayDiff(new int[]{1, 2, 3, 4, 4, 5, 6, 7, 7, 7},
                new int[]{7, 1}), new int[]{2, 3, 4, 4, 5, 6});
        assertArrayEquals(arrayDiff(new int[]{1, 2}, new int[]{1}), new int[]{2});
        assertArrayEquals(arrayDiff(new int[]{1, 2, 2}, new int[]{1}), new int[]{2, 2});
    }

    @Test
    public void arrayDiffImperativeTest() {
        assertArrayEquals(arrayDiffImperative(new int[]{1, 2, 3, 4, 4, 5, 6, 7, 7, 7}, new int[]{7, 1}),
                new int[]{2, 3, 4, 4, 5, 6});
        assertArrayEquals(arrayDiffImperative(new int[]{1, 2}, new int[]{1}), new int[]{2});
        assertArrayEquals(arrayDiffImperative(new int[]{1, 2, 2}, new int[]{1}), new int[]{2, 2});
    }
}
