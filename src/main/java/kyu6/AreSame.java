package kyu6;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreSame {

    //6 https://www.codewars.com/kata/550498447451fbbd7600041c/train/java

    @Test
    public void test1() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertTrue(AreSame.comp(a, b));
    }

    @Test
    public void test2() {
        int[] a = new int[]{0, -14, 191, 161, 19, 144, 195, 1};
        int[] b = new int[]{1, 0, 196, 36481, 25921, 361, 20736, 38025};
        assertTrue(AreSame.comp(a, b));
    }

    @Test
    public void test3() {
        int[] a = new int[]{0, -14, 191, 161, 19, 144, 195, 1};
        int[] b = null;
        assertFalse(AreSame.comp(a, b));
    }

    public static boolean comp(int[] a, int[] b) {
        return a != null && b != null && Arrays.equals(Arrays.stream(a).map(i -> i * i).sorted().toArray(), Arrays.stream(b).sorted().toArray());
    }
}
