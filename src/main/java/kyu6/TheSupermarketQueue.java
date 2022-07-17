package kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//6 https://www.codewars.com/kata/57b06f90e298a7b53d000a86/train/java

public class TheSupermarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {

        if (customers.length == 0) return 0;
        int max = Arrays.stream(customers).max().orElseThrow();

        if (max < n) return max;

        LinkedList<Integer> integers = new LinkedList<>();
        for (int i : customers)
            integers.add(i);

        int[] workList = new int[n];

        for (int i = 0; i < n; i++) {
            if (!integers.isEmpty()) {

                workList[i] = integers.pollFirst();
            } else {
                workList[i] = 0;
            }
        }

        int count = 0;

        while (true) {
            int stopCount = 0;
            for (int j : workList) {
                if (j == -1) {
                    stopCount++;
                }
            }

            if (stopCount == n) break;

            count++;

            for (int i = 0; i < workList.length; i++) {
                if (workList[i] > 1) {
                    workList[i]--;
                } else if (!integers.isEmpty()) {
                    workList[i] = integers.pollFirst();
                } else {
                    workList[i] = -1;
                }
            }
        }

        return count;
    }

    @Test
    public void testNormalCondition() {
        assertEquals(9, solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
        assertEquals(0, solveSuperMarketQueue(new int[]{}, 1));
        assertEquals(15, solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 1));
        assertEquals(5, solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 100));
        assertEquals(19, solveSuperMarketQueue(new int[]{5, 7, 4, 5, 6, 5, 3, 1, 3, 1, 2, 1, 5, 5}, 3));
    }
}
