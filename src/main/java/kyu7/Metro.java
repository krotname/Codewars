package kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//6 https://www.codewars.com/kata/5648b12ce68d9daa6b000099/solutions/java

public class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {
        return stops.stream()
                .reduce(((ints1, ints2) -> new int[]{ints1[0] + ints2[0], ints1[1] + ints2[1]}))
                .map(ints -> ints[0] - ints[1])
                .orElseThrow();
    }


    @Test
    public void test1() {
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{10, 0});
        list.add(new int[]{3, 5});
        list.add(new int[]{2, 5});
        assertEquals(5, countPassengers(list));
    }
}
