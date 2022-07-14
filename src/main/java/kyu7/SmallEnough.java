package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmallEnough {
    //7 https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java

    public static boolean smallEnough(int[] a, int limit) {
        return Arrays.stream(a).allMatch(n -> n <= limit);
    }

    @Test
    public void basicTests() {
        assertFalse(SmallEnough.smallEnough(new int[]{78, 117, 110, 99, 104, 117, 107, 115}, 100));
        assertTrue(SmallEnough.smallEnough(new int[]{66, 101}, 200));
        assertTrue(SmallEnough.smallEnough(new int[]{101, 45, 75, 105, 99, 107}, 107));
        assertTrue(SmallEnough.smallEnough(new int[]{80, 117, 115, 104, 45, 85, 112, 115}, 120));
    }
}
