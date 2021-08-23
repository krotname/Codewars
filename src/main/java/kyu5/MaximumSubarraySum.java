package kyu5;

import java.util.Arrays;

public class MaximumSubarraySum {
//5
/*    The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:

    Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.

    Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.*/

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // should be 6: {4, -1, 2, 1}
        System.out.println(sequence(new int[]{2, -3, 3}));
        System.out.println(sequence(new int[]{-1, -5, -9, -88})); // should be 0
        System.out.println(sequence(new int[]{4, -1, 2, 1}));
        System.out.println(sequence(new int[]{-2, 1, -3, 5, -1, 2, 1, -5, 4}));
        System.out.println(sequence(new int[]{333, -11, -3, 5, -1, 2, 1, -5, 4}));
        System.out.println(sequence(new int[]{3, 1, -3, 5, -1, 2, 1, -55, 555}));
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

    public static int arraySum(int[] arr) {
        int result = 0;
        for (int i : arr
        ) {
            result += i;
        }
        return result;
    }
}
