package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetXO {

    //7

    public static boolean getXO(String str) {

        int xCount = counterStr(str, "x");
        int yCount = counterStr(str, "o");
        return xCount == yCount;

    }

    public static int counterStr(String str, String target) {

        int result = 0;
        for (char element : str.toLowerCase().toCharArray()) {
            if (element == target.toLowerCase().toCharArray()[0]) result++;
        }
        return result;
    }

    /**
     * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean
     * and be case insensitive. The string can contain any char.
     * <p>
     * Examples input/output:
     * <p>
     * XO("ooxx") => true
     * XO("xooxx") => false
     * XO("ooxXm") => true
     * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
     * XO("zzoo") => false
     */

    @Test
    public void test() {
        assertTrue(getXO("XxxooO"));
        assertFalse(getXO("XolO"));
    }
}
