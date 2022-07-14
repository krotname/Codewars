package kyu5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MaximumSubarraySum {

    //5

    /**
     * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
     * <p>
     * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
     * <p>
     * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
     */

    @Test
    public void test() {
        assertEquals(6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(3, sequence(new int[]{2, -3, 3}));
        assertEquals(0, sequence(new int[]{-1, -5, -9, -88}));
        assertEquals(6, sequence(new int[]{4, -1, 2, 1}));
        assertEquals(7, sequence(new int[]{-2, 1, -3, 5, -1, 2, 1, -5, 4}));
        assertEquals(333, sequence(new int[]{333, -11, -3, 5, -1, 2, 1, -5, 4}));
        assertEquals(555, sequence(new int[]{3, 1, -3, 5, -1, 2, 1, -55, 555}));
    }

    public static int sequence(int[] arr) {
        int maximumSubarraySum = arraySum(arr);
        for (int i = 0; i <= arr.length; i++) {
            for (int j = arr.length; j >= i; j--) {
                int[] ints = Arrays.copyOfRange(arr, i, j);
                int subarraySum = arraySum(ints);
                if (subarraySum > maximumSubarraySum) {
                    maximumSubarraySum = subarraySum;
                }
            }
        }
        return maximumSubarraySum;
    }

    private static int arraySum(int[] arr) {
        int result = 0;
        for (int i : arr
        ) {
            result += i;
        }
        return result;
    }
}
