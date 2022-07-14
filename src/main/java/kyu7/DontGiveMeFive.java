package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DontGiveMeFive {

    //7 https://www.codewars.com/kata/5813d19765d81c592200001a/solutions/java

    public static int dontGiveMeFive(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (!String.valueOf(i).contains("5")) count++;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(8, dontGiveMeFive(1, 9));
        assertEquals(12, dontGiveMeFive(4, 17));
    }
}
