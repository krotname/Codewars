package kyu6;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {
    //6

    /**
     * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
     * <p>
     * Examples
     * "din"      =>  "((("
     * "recede"   =>  "()()()"
     * "Success"  =>  ")())())"
     * "(( @"     =>  "))(("
     */
    public static void main(String[] args) {
        System.out.println(encode("Prespecialized")); // )()())()(()()(
        System.out.println(encode("recede"));
        System.out.println(encode("Success"));
        System.out.println(encode("(( @"));
        System.out.println(encode("asfdafbsrtgsdcvxcvbnmjh,klo;p["));
        System.out.println(encode("   ()(   ")); // ))))())))
    }

    static String encode(String word) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : word.toCharArray()
        ) {
            map.putIfAbsent(Character.toLowerCase(c), 0);
            map.put(Character.toLowerCase(c), map.get(Character.toLowerCase(c)) + 1);
        }
        for (Character c : word.toCharArray()
        ) {
            if (map.get(Character.toLowerCase(c)) > 1) {
                result.append(")");
            } else {
                result.append("(");
            }
        }
        return result.toString();
    }
}
