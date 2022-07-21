package kyu6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTheOdd {

    // 6 https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/train/java

    public static int[] sortArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();

        for (int i = 0; i < array.length; i += 2) {
            odd.add(array[i]);
        }

        Collections.sort(odd);

        for (int i = 0; i < array.length; i += 2) {
            array[i] = odd.get((int) (i / 2.0 + 0.5));
        }
        return array;
    }

    public static int[] sortArrayStream(int[] array) {
        LinkedList<Integer> oddSorted = IntStream
                .range(0, array.length)
                .filter(x -> x % 2 == 0)
                .map(x -> array[x])
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        IntStream.range(0, array.length).forEach(
                x -> {
                    if (x % 2 == 0) {
                        array[x] = oddSorted.pollFirst();
                    }
                });

        return array;
    }

    @Test
    public void exampleTestStream() {
        assertArrayEquals(new int[]{0, 3, 1, 8, 5}, sortArrayStream(new int[]{5, 3, 1, 8, 0}));
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, sortArrayStream(new int[]{5, 3, 2, 8, 1, 4}));
        assertArrayEquals(new int[]{}, sortArrayStream(new int[]{}));
    }

    @Test
    public void exampleTest() {
        assertArrayEquals(new int[]{0, 3, 1, 8, 5}, sortArray(new int[]{5, 3, 1, 8, 0}));
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, sortArray(new int[]{5, 3, 2, 8, 1, 4}));
        assertArrayEquals(new int[]{}, sortArray(new int[]{}));
    }
}
