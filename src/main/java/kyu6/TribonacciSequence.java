package kyu6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TribonacciSequence {

    public double[] tribonacci(double[] s, int n) {
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


    private TribonacciSequence variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new TribonacciSequence();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    private double precision = 1e-10;

    @Test
    public void sampleTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, variabonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, variabonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, variabonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
        variabonacci.tribonacci(new double[]{18.0, 0.0, 17.0}, 49);
        variabonacci.tribonacci(new double[]{9.0, 0.0, 20.0}, 1);
    }

}
