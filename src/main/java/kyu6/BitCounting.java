package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BitCounting {

    //6 https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java

    @Test
    public void BitCountingTest() {
        assertEquals(5, BitCounting.countBits(1234));
        assertEquals(1, BitCounting.countBits(4));
        assertEquals(3, BitCounting.countBits(7));
        assertEquals(2, BitCounting.countBits(9));
        assertEquals(2, BitCounting.countBits(10));
    }

    public static int countBits(int n) {
        return (int) Integer.toBinaryString(n).chars().filter(c -> c == '1').count();
    }

}
