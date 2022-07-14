package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSum {

    //7 https://www.codewars.com/kata/55f2b110f61eb01779000053/train/java

    public static int getSum(int a, int b) {
        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }

    @Test
    public void test() {
        assertEquals(1, getSum(0, 1));
        assertEquals(1, getSum(1, 1));
        assertEquals(-1, getSum(-1, 0));
        assertEquals(2, getSum(-1, 2));
    }
}
