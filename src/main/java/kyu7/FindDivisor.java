package kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDivisor {

    //7 https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java

    public static long numberOFindDivisorivisors(int i) {
        return IntStream.range(1, i + 1)
                .filter(n -> i % n == 0)
                .count();
    }

    @Test
    public void oneTest() {
        assertEquals(1, FindDivisor.numberOFindDivisorivisors(1));
        assertEquals(3, FindDivisor.numberOFindDivisorivisors(4));
        assertEquals(2, FindDivisor.numberOFindDivisorivisors(5));
        assertEquals(6, FindDivisor.numberOFindDivisorivisors(12));
        assertEquals(8, FindDivisor.numberOFindDivisorivisors(30));
    }
}