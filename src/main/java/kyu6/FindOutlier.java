package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOutlier {
    //6

    public static int find(int[] integers) {

        if (integers == null || integers.length < 3) {
            throw new IllegalArgumentException();
        }
        boolean evenNumber = integers[0] % 2 == 0 && integers[1] % 2 == 0;
        if ((integers[0] % 2 != 0 && integers[1] % 2 == 0 && integers[2] % 2 != 0)) {
            return integers[1];
        }
        if ((integers[0] % 2 == 0 && integers[1] % 2 != 0 && integers[2] % 2 != 0)) {
            return integers[0];
        }
        if ((integers[0] % 2 == 0 && integers[1] % 2 != 0 && integers[2] % 2 == 0)) {
            return integers[1];
        }
        if ((integers[0] % 2 != 0 && integers[1] % 2 == 0 && integers[2] % 2 == 0)) {
            return integers[0];
        }
        for (int i = 2; i < integers.length; i++) {
            if (evenNumber && integers[i] % 2 != 0) return integers[i];
            if (!evenNumber && integers[i] % 2 == 0) return integers[i];
        }
        return -1;
    }

    /**
     * Since we are warned the array may be very large, we should avoid counting values any more than we need to.
     * <p>
     * We only need the first 3 integers to determine whether we are chasing odds or evens.
     * So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
     * It will be 0 for even numbers and 1 for odd numbers.
     * Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
     */

    @Test
    public void test() {
        assertEquals(3, find(new int[]{2, 6, 8, -10, 3}));
        assertEquals(206847684, find(new int[]{206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781}));
        assertEquals(0, find(new int[]{Integer.MAX_VALUE, 0, 1}));
        assertEquals(11, find(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
        assertEquals(160, find(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }

}
