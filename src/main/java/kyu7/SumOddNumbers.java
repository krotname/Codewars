package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOddNumbers {

    //7 https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/train/java

    public static int rowSumOddNumbers(int n) {
        int result = 0;
        int r = n * (n + 1) / 2 * 2 - 1;
        for (int i = 0; i < n; i++) {
            result += r - i * 2;
        }
        return result;
        // return n*n*n;
    }

    @Test
    public void test1() {
        assertEquals(1, rowSumOddNumbers(1));
        assertEquals(74088, rowSumOddNumbers(42));
    }
}
