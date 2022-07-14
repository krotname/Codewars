package kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighAndLow {
    //7 https://www.codewars.com/kata/554b4ac871d6813a03000035/train/java

    public static String highAndLow(String numbers) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (String s : numbers.split("\\s")) {
            integers.add(Integer.valueOf(s));
        }
        Collections.sort(integers);
        return integers.get(integers.size() - 1) + " " + integers.get(0);
    }

    public static Integer high(String numbers) {
        return Arrays.stream(numbers.split("\\s"))
                .map(Integer::valueOf)
                .toList()
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    @Test
    public void test() {
        assertEquals("42 -9", highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
        assertEquals(42, high("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

}
