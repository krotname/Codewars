package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitalRoot {

    //6

    public static int digitalRootRecursiveStream(int n) {
        return n < 10 ? n : digitalRootRecursiveStream(String.valueOf(n)
                .chars()
                .map(i -> Integer.parseInt(String.valueOf((char) i)))
                .sum());
    }

    public static int digitalRoot(int n) {
        if (n < 10) return n;
        int temp = n;
        int result;
        do {
            result = 0;
            while (temp > 0) {
                result = result + temp % 10;
                temp /= 10;
            }
            temp = result;
        } while (result > 9);
        return result;
    }

    /**
     * Digital root is the recursive sum of all the digits in a number.
     * Given n, take the sum of the digits of n. If that value has more than one
     * digit, continue reducing in this way until a single-digit number is produced.
     * The input will be a non-negative integer.
     */

    @Test
    public void digitalRootRecursiveStreamTest() {
        assertEquals(7, digitalRootRecursiveStream(16));
        assertEquals(6, digitalRootRecursiveStream(456));
        assertEquals(2, digitalRootRecursiveStream(493193));
    }

    @Test
    public void digitalRootTest() {
        assertEquals(7, digitalRoot(16));
        assertEquals(6, digitalRoot(456));
        assertEquals(2, digitalRoot(493193));
    }
}
