package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringSplit {

    //6 https://www.codewars.com/kata/515de9ae9dcfc28eb6000001/train/java

    /**
     * Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').
     * <p>
     * Examples:
     * <p>
     * StringSplit.solution("abc") // should return {"ab", "c_"}
     * StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}
     */

    @Test
    public void test() {
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, solution("abcdef"));
        assertArrayEquals(new String[]{"Lo", "ve", "Pi", "zz", "a_"}, solution("LovePizza"));
        assertArrayEquals(new String[]{"He", "ll", "oW", "or", "ld"}, solution("HelloWorld"));
    }

    public static String[] solution(String s) {
        int d;
        String[] result;
        if (s.length() % 2 == 0) {
            d = s.length() / 2;
            result = new String[d];
            for (int i = 1; i <= d; i++) {
                int k = i * 2;
                result[i - 1] = s.substring(k - 2, k);
            }
        } else {
            d = s.length() / 2 + 1;
            result = new String[d];
            for (int i = 1; i <= d - 1; i++) {
                int k = i * 2;
                result[i - 1] = s.substring(k - 2, k);
            }
            result[d - 1] = s.substring(s.length() - 1) + "_";
        }
        return result;
    }

}
