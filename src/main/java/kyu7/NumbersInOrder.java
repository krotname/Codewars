package kyu7;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class NumbersInOrder {
    //7 https://www.codewars.com/kata/56b7f2f3f18876033f000307/train/java

    public static boolean isAscOrder(int[] arr) {
        return IntStream.range(0, arr.length-1)
                .allMatch(i -> arr[i+1] >= arr[i]);
    }

    @Test
    public void arrayOf2Integers() {
        assertTrue(isAscOrder(new int[]{1, 2}));
        assertFalse(isAscOrder(new int[]{2, 1}));
    }

    @Test
    public void arrayOf3Integers() {
        assertTrue(isAscOrder(new int[]{1, 2, 3}));
        assertFalse(isAscOrder(new int[]{1, 3, 2}));
        assertTrue(isAscOrder(new int[]{1, 4, 13, 97, 508, 1047, 20058}));
        assertFalse(isAscOrder(new int[]{56, 98, 123, 67, 742, 1024, 32, 90969}));
    }

    @Test
    public void moreAdvancedCases() {
        assertTrue(isAscOrder(new int[]{1, 4, 13, 97, 508, 1047, 20058}));
        assertFalse(isAscOrder(new int[]{56, 98, 123, 67, 742, 1024, 32, 90969}));
    }

}
