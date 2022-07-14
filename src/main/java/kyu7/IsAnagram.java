package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IsAnagram {

    @Test
    public void test() {
        System.out.println(isAnagram("foefet", "toffee"));
        System.out.println(isAnagram("Buckethead", "DeathCubeK"));
    }

    public static boolean isAnagram(String test, String original) {
        char[] testChars = test.toLowerCase().toCharArray();
        char[] originalChars = original.toLowerCase().toCharArray();
        Arrays.sort(testChars);
        Arrays.sort(originalChars);
        return Arrays.equals(testChars, originalChars);
    }
}
