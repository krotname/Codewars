package kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindEvenIndex {

    public static int findEvenIndexV2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (findHalf1(arr, i) == findHalf2(arr, i)) {
                return i;
            }
        }
        return -1;
    }

    private static int findHalf1(int[] arr, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += arr[j];
        }
        return sum;
    }

    private static int findHalf2(int[] arr, int i) {
        int sum = 0;
        for (int j = i + 1; j < arr.length; j++) {
            sum += arr[j];
        }
        return sum;

    }

    public static int findEvenIndexV1(int[] arr) {

        int sumArr = IntStream.of(arr).sum();
        int firstHalfSumm = 0;
        int secondHalfSumm = 0;
        int halfIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            firstHalfSumm += arr[i];
            if (firstHalfSumm >= (sumArr / 2)) {
                halfIndex = i;
                firstHalfSumm -= arr[i];
                break;
            }
        }
        for (int i = arr.length - 1; i > halfIndex; i--) {
            secondHalfSumm += arr[i];
        }
        if (firstHalfSumm == secondHalfSumm) return halfIndex;
        return -1;
    }

    @Test
    public void testV2() {
        assertEquals(3, findEvenIndexV2(new int[]{1, 2, 3, 4, 3, 2, 1}));
        assertEquals(1, findEvenIndexV2(new int[]{1, 100, 50, -51, 1, 1}));
        assertEquals(-1, findEvenIndexV2(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, findEvenIndexV2(new int[]{20, 10, 30, 10, 10, 15, 35}));
        assertEquals(-1, findEvenIndexV2(new int[]{-8505, -5130, 1926, -9026}));
        assertEquals(1, findEvenIndexV2(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6, findEvenIndexV2(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }

    @Test
    public void testV1() {
        assertEquals(3, findEvenIndexV1(new int[]{1, 2, 3, 4, 3, 2, 1}));
        assertEquals(1, findEvenIndexV1(new int[]{1, 100, 50, -51, 1, 1}));
        assertEquals(-1, findEvenIndexV1(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, findEvenIndexV1(new int[]{20, 10, 30, 10, 10, 15, 35}));
        assertEquals(-1, findEvenIndexV1(new int[]{-8505, -5130, 1926, -9026}));
        assertEquals(1, findEvenIndexV1(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6, findEvenIndexV1(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }
}