package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vowels {

    //7

    /**
     * Return the number (count) of vowels in the given string.
     * <p>
     * We will consider a, e, i, o, u as vowels for this Kata (but not y).
     * <p>
     * The input string will only consist of lower case letters and/or spaces.
     */

    public static int getCount(String str) {
        int vowelsCount = 0;

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

        for (char c : str.toCharArray()
        ) {
            if (vowels.contains(String.valueOf(c))) {
                vowelsCount++;
            }
        }

        return vowelsCount;
    }

    @Test
    public void test() {
        assertEquals(5, getCount("abracadabra"));
    }

}