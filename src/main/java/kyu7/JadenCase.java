package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JadenCase {

    //7 https://www.codewars.com/kata/5390bac347d09b7da40006f6/train/java

    @Test
    public void test() {
        assertEquals( "Most Trees Are Blue", toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull(toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull(toJadenCase(""));
    }

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.length() == 0) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : phrase.split("\\s")) {
            stringBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
