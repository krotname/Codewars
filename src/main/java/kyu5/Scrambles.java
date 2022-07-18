package kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Scrambles {

    // 5 https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java

    public static boolean scramble(String str1, String str2) {
        ArrayList<Character> list1
                = (ArrayList<Character>) str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        ArrayList<Character> list2
                = (ArrayList<Character>) str2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (Character c2 : list2
        ) {
            if (!list1.remove(c2)) return false;
        }
        return true;
    }

    /**
     * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged
     * to match str2, otherwise returns false.
     * <p>
     * Notes:
     * <p>
     * Only lower case letters will be used (a-z). No punctuation or digits will be included.
     * Performance needs to be considered
     * Input strings s1 and s2 are null terminated.
     * Examples
     * scramble('rkqodlw', 'world') ==> True
     * scramble('cedewaraaossoqqyt', 'codewars') ==> True
     * scramble('katas', 'steak') ==> False
     */

    @Test
    public void testTrue() {
        assertTrue(scramble("rkqodlw", "world"));
        assertTrue(scramble("cedewaraaossoqqyt", "codewars"));
        assertTrue(scramble("scriptingjava", "javascript"));
        assertTrue(scramble("scriptsjava", "javascript"));
        assertTrue(scramble("aabbcamaomsccdd", "commas"));
        assertTrue(scramble("commas", "commas"));
        assertTrue(scramble("sammoc", "commas"));
    }

    @Test
    public void testFalse() {
        assertFalse(scramble("scriptjavx", "javascript"));
        assertFalse(scramble("javscripts", "javascript"));
        assertFalse(scramble("katas", "steak"));
    }
}
