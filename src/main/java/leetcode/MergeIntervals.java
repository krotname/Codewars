package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MergeIntervals {
    //Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return
    // an array of the non-overlapping intervals that cover all the intervals in the input.
    // https://leetcode.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        if (Objects.isNull(intervals) || Objects.isNull(intervals[0])) throw new IllegalArgumentException();

        var maxInt = intervals[intervals.length - 1][1];
        var integersSet = new TreeSet<Integer>();
        var resultList = new ArrayList<int[]>();
        var currentInterval = 0;

        for (int[] interval : intervals) {
            for (int j = interval[0]; j <= interval[1]; j++) {
                integersSet.add(j);
            }
        }

        for (int i = 0; i <= maxInt; i++) {
            if (integersSet.contains(i)) {
                currentInterval++;
            } else if (currentInterval != 0) {
                resultList.add(new int[]{i - currentInterval, i - 1});
                currentInterval = 0;
            }
        }
        if (currentInterval != 0) {
            resultList.add(new int[]{maxInt - currentInterval + 1, maxInt});
        }

        return getResult(resultList);
    }

    private static int[][] getResult(ArrayList<int[]> resultList) {
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    @Test
    public void test1() {
        int[][] input = {{2, 4}, {3, 6}, {8, 10}, {15, 18}};
        int[][] output = {{2, 6}, {8, 10}, {15, 18}};
        assertArrayEquals(output, merge(input));
    }

    @Test
    public void test2() {
        int[][] input = {{1, 18}};
        int[][] output = {{1, 18}};
        assertArrayEquals(output, merge(input));
    }

    @Test
    public void test3() {
        int[][] input = null;
        assertThrows(IllegalArgumentException.class, () -> merge(input));
    }

    @Test
    public void test4() {
        int[][] input = {{1, 10}, {10, 18}};
        int[][] output = {{1, 18}};
        assertArrayEquals(output, merge(input));
    }
}