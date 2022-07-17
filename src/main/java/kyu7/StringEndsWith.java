package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringEndsWith {

    //7 https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d

    private static void check(String str, String ending, boolean expected) {
        boolean result = solution(str, ending);
        assertEquals(expected, result);
    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    @Test
    public void staticTests() {
        check("samurai", "ai", true);
        check("sumo", "omo", false);
        check("ninja", "ja", true);
        check("sensei", "i", true);
        check("samurai", "ra", false);
        check("abc", "abcd", false);
        check("abc", "abc", true);
        check("abcabc", "bc", true);
        check("ails", "fails", false);
        check("fails", "ails", true);
        check("this", "fails", false);
        check("this", "", true);
        check(":-)", ":-(", false);
        check("!@#$%^&*() :-)", ":-)", true);
        check("abc\n", "abc", false);
    }
}
