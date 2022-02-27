package kyu6;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class DigPow {

    public static long digPow(int n, int p) {
        AtomicInteger pa = new AtomicInteger(p);
        int sum = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .map(i -> (int) Math.pow(i, pa.getAndIncrement()))
                .sum();
        return sum % n == 0 ? sum / n : -1;
    }

    @Test
    public void Test1() {
        assertEquals(1, DigPow.digPow(89, 1));
    }

    @Test
    public void Test2() {
        assertEquals(-1, DigPow.digPow(92, 1));
    }

    @Test
    public void Test3() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }
}
