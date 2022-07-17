package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindShort {

    //7 https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9/train/java

    public static int findShort(String s) {
        if (s == null || s.length() == 0) return 0;
        if (!s.contains(" ")) return s.length();
        int min = Integer.MAX_VALUE;
        for (String s1 : s.split(" ")) {
            min = Math.min(min, s1.length());
        }
        return min;
    }

    @Test
    public void test() {
        assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(7, findShort("bitcoin"));
    }
}
