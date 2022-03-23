package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildaPileOfCubes {

    //6 https://www.codewars.com/kata/5592e3bd57b64d00f3000047

    public static long findNb(long m) {
        for (long i = 0; m >=0; i++) {
            m -= i*i*i;
            if (m == 0 ) return i;
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

    @Test
    public void testM() {
        assertEquals(1071225, findM(45));
    }

    @Test
    public void test0() {
        assertEquals(45, BuildaPileOfCubes.findNb(1071225));
    }

    @Test
    public void test1() {
        assertEquals(2022, BuildaPileOfCubes.findNb(4183059834009L));
    }

    @Test
    public void test2() {
        assertEquals(-1, BuildaPileOfCubes.findNb(24723578342962L));
    }

    @Test
    public void test3() {
        assertEquals(4824, BuildaPileOfCubes.findNb(135440716410000L));
    }

    @Test
    public void test4() {
        assertEquals(3568, BuildaPileOfCubes.findNb(40539911473216L));
    }
}
