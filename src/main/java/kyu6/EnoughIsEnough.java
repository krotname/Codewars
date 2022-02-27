package kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        HashMap<Integer, Integer> count = new HashMap<>();
        return Arrays.stream(elements).filter(i -> {
           // return count.merge(i, 1, (u, h) -> u+h) <= maxOccurrences; // счётчик через HashMap
            count.computeIfPresent(i, (key, value) -> ++value);
            count.putIfAbsent(i, 1);
            return count.get(i) <= maxOccurrences;
        }).toArray();
    }

    @Test
    public void show(){
        System.out.println(Arrays.toString(EnoughIsEnough.deleteNth(new int[]{20, 37, 20, 21}, 1)));
    }

    @Test
    public void deleteNth() {
        assertArrayEquals(
                new int[]{20, 37, 21},
                EnoughIsEnough.deleteNth(new int[]{20, 37, 20, 21}, 1)
        );
        assertArrayEquals(
                new int[]{1, 1, 3, 3, 7, 2, 2, 2},
                EnoughIsEnough.deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)

        );
        assertArrayEquals(
                new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5},
                EnoughIsEnough.deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)
        );
        assertArrayEquals(
                new int[]{1, 1, 1, 1, 1},
                EnoughIsEnough.deleteNth(new int[]{1, 1, 1, 1, 1}, 5)
        );
        assertArrayEquals(
                new int[]{},
                EnoughIsEnough.deleteNth(new int[]{}, 5)
        );

    }
}
