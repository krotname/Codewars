package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NbYear {

    //7 https://www.codewars.com/kata/563b662a59afc2b5120000c6/train/java

    @Test
    public void test1() {
        assertEquals(nbYear(1500, 5, 100, 5000),15);
        assertEquals(nbYear(1500000, 2.5, 10000, 2000000), 10);
        assertEquals(nbYear(1500000, 0.25, 1000, 2000000), 94);
    }
    public static int nbYear(int p0, double percent, int aug, int p) {
        int year = 0;
        while (p0 < p) {
            p0 = (int) (p0 + (p0 * (percent / 100) + aug));
            year++;
        }
        return year;
    }

}
