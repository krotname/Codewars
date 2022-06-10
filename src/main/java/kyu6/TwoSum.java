package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwoSum {
    //6 https://www.codewars.com/kata/52c31f8e6605bcc646000082/train/java

    public static int[] twoSum(int[] numbers, int target) { // O(n^2)
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }


    @Test
    public void basicTests() {
        doTest(new int[]{1, 2, 3}, new int[]{0, 2});
        doTest(new int[]{1234, 5678, 9012}, new int[]{1, 2});
        doTest(new int[]{2, 2, 3}, new int[]{0, 1});
    }

    private void doTest(int[] numbers, int[] expected) {
        int target = numbers[expected[0]] + numbers[expected[1]];
        int[] actual = TwoSum.twoSum(numbers, target);
        if (null == actual) {
            System.out.format("Received a null\n");
            assertNotNull(actual);
        }
        if (actual.length != 2) {
            System.out.format("Received an array that's not of length 2\n");
            assertTrue(false);
        }
        int received = numbers[actual[0]] + numbers[actual[1]];
        assertEquals(target, received);
    }

    private void assertNotNull(int[] actual) {
    }

}
