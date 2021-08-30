package kyu5;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Scramblies {
    //5 https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java

    /*Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

Notes:

Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered
Input strings s1 and s2 are null terminated.
Examples
scramble('rkqodlw', 'world') ==> True
scramble('cedewaraaossoqqyt', 'codewars') ==> True
scramble('katas', 'steak') ==> False*/
    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world")); // true
        System.out.println(scramble("cedewaraaossoqqyt", "codewars")); // true
        System.out.println(scramble("katas", "steak")); // false
        System.out.println(scramble("scriptjavx", "javascript")); // false
        System.out.println(scramble("scriptingjava", "javascript")); // true
        System.out.println(scramble("scriptsjava", "javascript")); // true
        System.out.println(scramble("javscripts", "javascript")); // false
        System.out.println(scramble("aabbcamaomsccdd", "commas")); // true
        System.out.println(scramble("commas", "commas")); // true
        System.out.println(scramble("sammoc", "commas")); // true
    }

    /*        HashSet<Character> set1 =
                    (HashSet<Character>) str1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());*/
    // https://stackoverflow.com/questions/15590675/converting-char-array-to-list-in-java

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
}
