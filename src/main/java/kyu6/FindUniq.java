package kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindUniq {

    //7 https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java

    private final static double PRECISION = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindUniq.findUniq(new double[]{0, 1, 0}), PRECISION);
        assertEquals(2.0, FindUniq.findUniq(new double[]{1, 1, 1, 2, 1, 1}), PRECISION);
    }

    public static double findUniq(double[] arr) {
        double m;
        if (arr[0] == arr[1]) {
            m = arr[0];
        } else {
            m = arr[2];
        }
        return Arrays.stream(arr).parallel().filter(i -> i != m).findAny().orElseThrow();
    }
}
