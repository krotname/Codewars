package kyu6;

//6 https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/java

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestEnd {

    @Test
    public void test() {
        assertEquals("oocccffuucccjjjkkkjyyyeehh", longestEnd(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1));
        assertEquals("abigailtheta", longestEnd(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
        assertEquals("", longestEnd(new String[]{}, 3));
        assertEquals("wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck", longestEnd(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2));
        assertEquals("wlwsasphmxxowiaxujylentrklctozmymu", longestEnd(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2));
        assertEquals("", longestEnd(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2));
        assertEquals("ixoyx3452zzzzzzzzzzzz", longestEnd(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3));
        assertEquals("", longestEnd(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15) );
        assertEquals("", longestEnd(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0));
    }

    public static String longestEnd(String[] strarr, int k) {
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
}
