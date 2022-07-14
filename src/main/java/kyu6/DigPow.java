package kyu6;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void test() {
        assertEquals(1, DigPow.digPow(89, 1));
        assertEquals(-1, DigPow.digPow(92, 1));
        assertEquals(51, DigPow.digPow(46288, 3));
    }
}
