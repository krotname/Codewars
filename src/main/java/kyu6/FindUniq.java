package kyu6;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindUniq {
    public static double findUniq(double arr[]) {
        double m;
        if (arr[0] == arr[1]) {
            m = arr[0];
        } else {
            m = arr[2];
        }
        return Arrays.stream(arr).parallel().filter(i -> i != m).findAny().orElseThrow();
    }

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindUniq.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindUniq.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }

}
