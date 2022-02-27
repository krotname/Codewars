package kyu7;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class MaxMultiple {
    //7 https://www.codewars.com/kata/5aba780a6a176b029800041c/train/java

    public static int maxMultiple(int divisor, int bound) {
        return IntStream.iterate(bound, i -> i-1)
                .limit(bound)
                .filter(n -> n % divisor == 0)
                .findFirst()
                .orElse(0);
    }

    @Test
    public void smallPositives() {
        test("The largest multiple of 2 between 0 and 7 is 6.", 6, MaxMultiple.maxMultiple(2, 7));
        test("The largest multiple of 3 between 0 and 10 is 9.", 9, MaxMultiple.maxMultiple(3, 10));
        test("The largest multiple of 7 between 0 and 17 is 14.", 14, MaxMultiple.maxMultiple(7, 17));
    }

    @Test
    public void largerPositives() {
        test("The largest multiple of 10 between 0 and 50 is 50.", 50, MaxMultiple.maxMultiple(10, 50));
        test("The largest multiple of 37 between 0 and 200 is 185.", 185, MaxMultiple.maxMultiple(37, 200));
        test("The largest multiple of 7 between 0 and 100 is 98.", 98, MaxMultiple.maxMultiple(7, 100));
    }
    private void test(String message, int expected, int actual) {
        assertEquals(expected, actual);
    }

}
