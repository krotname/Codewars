package kyu6;

//6 https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/java

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        ArrayList<String> strings = new ArrayList<>();
        for (int n = 0; n < strarr.length - k + 1; n++) {
            StringBuilder currentWord = new StringBuilder();
            for (int i = n; i < n + k; i++) {
                currentWord.append(strarr[i]);
            }
            strings.add(currentWord.toString());
        }

        return strings.stream().max(Comparator.comparing(String::length)).orElse("");
    }

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(LongestConsec.longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        testing(LongestConsec.longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        testing(LongestConsec.longestConsec(new String[]{}, 3), "");
        testing(LongestConsec.longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        testing(LongestConsec.longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        testing(LongestConsec.longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        testing(LongestConsec.longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        testing(LongestConsec.longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        testing(LongestConsec.longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
    }
}
