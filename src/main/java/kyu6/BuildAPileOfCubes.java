package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildAPileOfCubes {

    //6 https://www.codewars.com/kata/5592e3bd57b64d00f3000047

    @Test
    public void testM() {
        assertEquals(1071225, findM(45));
    }

    @Test
    public void testNb() {
        assertEquals(45, findNb(1071225));
        assertEquals(2022, findNb(4183059834009L));
        assertEquals(-1, findNb(24723578342962L));
        assertEquals(4824, findNb(135440716410000L));
        assertEquals(3568, findNb(40539911473216L));
    }

    public static long findNb(long m) {
        for (long i = 0; m >= 0; i++) {
            m -= i * i * i;
            if (m == 0) return i;
        }
        return -1;
    }

    public static long findM(long n) {
        long t = n;
        long r = 0;
        for (int i = 0; i < n; i++) {
            r += t * t * t;
            t--;
        }
        return r;
    }

}
