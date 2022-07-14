package kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EnoughIsEnough {

    //6 https://www.codewars.com/kata/554ca54ffa7d91b236000023

    @Test
    public void deleteNth() {

        assertArrayEquals(new int[]{20, 37, 21},
                EnoughIsEnough.deleteNth(new int[]{20, 37, 20, 21}, 1));

        assertArrayEquals(new int[]{1, 1, 3, 3, 7, 2, 2, 2},
                EnoughIsEnough.deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3));

        assertArrayEquals(new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5},
                EnoughIsEnough.deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3));

        assertArrayEquals(new int[]{1, 1, 1, 1, 1},
                EnoughIsEnough.deleteNth(new int[]{1, 1, 1, 1, 1}, 5));

        assertArrayEquals(new int[]{},
                EnoughIsEnough.deleteNth(new int[]{}, 5));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        HashMap<Integer, Integer> count = new HashMap<>();
        return Arrays.stream(elements).filter(i -> {
            count.computeIfPresent(i, (key, value) -> ++value);
            count.putIfAbsent(i, 1);
            return count.get(i) <= maxOccurrences;
        }).toArray();
    }
}
