package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumber {

    //6

    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    /**
     * Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
     */

    @Test
    public void test() {
        assertEquals("(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
