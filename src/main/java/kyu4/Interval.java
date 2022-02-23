package kyu4;

import java.util.HashSet;

public class Interval {
    //4 https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java

    /**
     * Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.
     * <p>
     * Intervals
     * Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
     * <p>
     * Overlapping Intervals
     * List containing overlapping intervals:
     * <p>
     * [
     * [1,4],
     * [7, 10],
     * [3, 5]
     * ]
     * The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
     * <p>
     * Examples:
     * // null argument
     * Interval.sumIntervals(null);  // => 0
     * <p>
     * // empty intervals
     * Interval.sumIntervals(new int[][]{});  // => 0
     * Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0
     * <p>
     * // disjoined intervals
     * Interval.sumIntervals(new int[][]{
     * {1,2},{3,5}
     * });  // => (2-1) + (5-3) = 3
     * <p>
     * // overlapping intervals
     * Interval.sumIntervals(new int[][]{
     * {1,4},{3,6},{2,8}
     * });  // [1,8] => 7
     */

    public static void main(String[] args) {
        System.out.println(sumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}})); //7
        System.out.println(sumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}})); //9
        System.out.println(sumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}})); //11
        System.out.println(sumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}})); //54
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        HashSet<Integer> integers = new HashSet<>();
        for (int[] pair : intervals
        ) {
            for (int i = pair[0]; i < pair[1]; i++) {
                integers.add(i);
            }
        }
        return integers.size();
    }

}
