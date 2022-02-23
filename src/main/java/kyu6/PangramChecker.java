package kyu6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PangramChecker {
    //6

    /**
     * pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     * <p>
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     */
    public static void main(String[] args) {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        System.out.println(check(pangram1));

        String pangram2 = "You shall not pass!";
        System.out.println(check(pangram2));
    }

    public static boolean check(String sentence) {
        Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        Set<Character> sentenceBetSet = new HashSet<>(26);
        for (char ch : sentence.toCharArray()
        ) {
            if (alphabet.contains(Character.toLowerCase(ch))) {
                sentenceBetSet.add(Character.toLowerCase(ch));
            }
            if (sentenceBetSet.size() == 26) return true;
        }
        return false;
    }
}
