package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddOrEvenArr {
    //7 https://www.codewars.com/kata/5949481f86420f59480000e7

    @Test
    public void exampleTest() {
        assertEquals("odd", oddOrEven(new int[] {2, 5, 34, 6}));
        assertEquals("even", oddOrEven(new int[] {2, 5, 34, 7}));
    }

    public static String oddOrEven(int[] array) {
        return Arrays.stream(array).sum() % 2 != 0 ? "odd" : "even";
    }
}
