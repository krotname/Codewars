package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TribonacciSequence {

    //6 https://www.codewars.com/kata/556deca17c58da83c00002db

    private static final double PRECISION = 1e-10;

    public static double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }
        if (n == 1) {
            double[] doubles = new double[1];
            doubles[0] = s[0];
            return doubles;
        }
        if (n == 2) {
            double[] doubles = new double[2];
            doubles[0] = s[0];
            doubles[1] = s[1];
            return doubles;
        }
        double[] doubles = new double[n];

        System.arraycopy(s, 0, doubles, 0, s.length);

        for (int i = s.length; i < n; i++) {
            doubles[i] = doubles[i - 1] + doubles[i - 2] + doubles[i - 3];
        }
        return doubles;
    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, tribonacci(new double[]{1, 1, 1}, 10), PRECISION);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, tribonacci(new double[]{0, 0, 1}, 10), PRECISION);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, tribonacci(new double[]{0, 1, 1}, 10), PRECISION);
        assertArrayEquals(new double[]{9.0}, tribonacci(new double[]{9.0, 0.0, 20.0}, 1));
        assertArrayEquals(new double[]{18.0, 0.0, 17.0, 35.0, 52.0, 104.0, 191.0, 347.0, 642.0, 1180.0, 2169.0, 3991.0, 7340.0, 13500.0, 24831.0, 45671.0, 84002.0, 154504.0, 284177.0, 522683.0, 961364.0, 1768224.0, 3252271.0, 5981859.0, 1.1002354E7, 2.0236484E7, 3.7220697E7, 6.8459535E7, 1.25916716E8, 2.31596948E8, 4.25973199E8, 7.83486863E8, 1.44105701E9, 2.650517072E9, 4.875060945E9, 8.966635027E9, 1.6492213044E10, 3.0333909016E10, 5.5792757087E10, 1.02618879147E11, 1.8874554525E11, 3.47157181484E11, 6.38521605881E11, 1.174424332615E12, 2.16010311998E12, 3.973049058476E12, 7.307576511071E12, 1.3440728689527E13, 2.4721354259074E13}, tribonacci(new double[]{18.0, 0.0, 17.0}, 49), PRECISION);
    }
}
