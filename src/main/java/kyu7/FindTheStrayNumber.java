package kyu7;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheStrayNumber {

    static int stray(int[] numbers) {
        if (numbers == null || numbers.length < 3) return 0;
        int base = 0;
        if (numbers[0] == numbers[1]) base = numbers[0];
        if (numbers[0] == numbers[2]) base = numbers[0];
        if (numbers[1] == numbers[2]) base = numbers[1];
        for (int i : numbers
        ) {
            if (i != base) return i;
        }
        return 0;
    }

    //7 https://www.codewars.com/kata/57f609022f4d534f05000024
    @Test
    public void test() {
        assertEquals(2, (stray(new int[]{1, 1, 2})));
        assertEquals(3, (stray(new int[]{17, 17, 3, 17, 17, 17, 17})));
    }
}
