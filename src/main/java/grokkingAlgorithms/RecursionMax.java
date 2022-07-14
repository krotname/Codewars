package grokkingAlgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionMax {

    private static final ArrayList<Integer> TEST_INTEGERS = new ArrayList<>(Arrays.asList(19, 2, 4, 5, 4));

    @Test
    public void testMax() {
        assertEquals(19, max(TEST_INTEGERS));
    }

    @Test
    public void testRecursionMax() {
        assertEquals(19, recursionMax(TEST_INTEGERS));
    }

    public static int recursionMax(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        if (array.isEmpty()) {
            return -1;
        }
        if (array.size() == 1) {
            return array.get(0);
        }
        if (array.size() == 2) {
            return Math.max(array.get(0), array.get(1));
        }
        int min = Math.min(array.get(0), array.get(1));
        array.remove((Integer) min);
        return recursionMax(array);
    }

    public static int max(List<Integer> array) {
        if (array == null) {
            return -1;
        }
        if (array.isEmpty()) {
            return -1;
        }
        if (array.size() == 1) {
            return array.get(0);
        }
        int max = Integer.MIN_VALUE;
        for (int a : array
        ) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
