package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsAnagram {

    public static boolean isAnagram(String test, String original) {
        char[] testChars = test.toLowerCase().toCharArray();
        char[] originalChars = original.toLowerCase().toCharArray();
        Arrays.sort(testChars);
        Arrays.sort(originalChars);
        return Arrays.equals(testChars, originalChars);
    }

    @Test
    public void test() {
        assertTrue(isAnagram("foefet", "toffee"));
        assertTrue(isAnagram("Buckethead", "DeathCubeK"));
        assertFalse(isAnagram("ckethead", "DeathCubeK"));
    }
}
