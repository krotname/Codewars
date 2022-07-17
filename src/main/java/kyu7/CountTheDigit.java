package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountTheDigit {

    public static int nbDig(int n, int d) {
        long count = 0;
        for (int i = 0; i <= n; i++) {
            String s = String.valueOf((int) Math.pow(i, 2));
            count += s.chars().filter(ch -> ch == Character.forDigit(d, 10)).count();
        }
        return (int) count;
    }

    @Test
    public void test() {
        assertEquals(9481, nbDig(11011, 2));
        assertEquals(4700, (nbDig(5750, 0)));
        assertEquals(3, (nbDig(10, 0)));
    }
}
