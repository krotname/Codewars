package kyu7;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MinimumLine {
    // 7 https://www.codewars.com/kata/5ac6932b2f317b96980000ca/train/java

    public static int minValue(int[] values) {

        return Integer.parseInt(Arrays.stream(values)
                .sorted()
                .distinct()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    @Test
    public void testSomething() {
        assertEquals(13, MinimumLine.minValue(new int[]{1, 3, 1}));
        assertEquals(457, MinimumLine.minValue(new int[]{4, 7, 5, 7}));
        assertEquals(148, MinimumLine.minValue(new int[]{4, 8, 1, 4}));
        assertEquals(579, MinimumLine.minValue(new int[]{5, 7, 9, 5, 7}));
        assertEquals(678, MinimumLine.minValue(new int[]{6, 7, 8, 7, 6, 6}));

    }
}
