package kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesOf3or5 {

    //6 https://www.codewars.com/kata/514b92a657cdc65150000006/train/java

    public static int multiplesOf3or5(int number) {
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (i % 5 == 0 || i % 3 == 0) result += i;
        }
        return result;
    }

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.
     * <p>
     * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
     * Additionally, if the number is negative, return 0 (for languages that do have them).
     * <p>
     * Note: If the number is a multiple of both 3 and 5, only count it once.
     */

    @Test
    public void test() {
        assertEquals(23, multiplesOf3or5(10));
        assertEquals(2318, multiplesOf3or5(100));
    }

    @Test
    public void testSteam() {
        assertEquals(23, multiplesOf3or5Stream(10));
        assertEquals(2318, multiplesOf3or5Stream(100));
    }

    public int multiplesOf3or5Stream(int number) {
        return IntStream.range(0, number)
                .filter(i -> i % 5 == 0 || i % 3 == 0)
                .sum();
    }

}
