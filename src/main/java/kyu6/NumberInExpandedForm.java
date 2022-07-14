package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//6 https://www.codewars.com/kata/5842df8ccbd22792a4000245/train/java

public class NumberInExpandedForm {

    public static String expandedForm(int num) {
        StringBuilder result = new StringBuilder();
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result.append(chars[i]).append("0".repeat(Math.max(0, chars.length - (i + 1)))).append(" + ");
            }
        }
        return result.substring(0, result.length() - 3);
    }

    @Test
    public void testSomething() {
        assertEquals("9000000", expandedForm(9000000));
        assertEquals("70000 + 300 + 4", expandedForm(70304));
        assertEquals("10 + 2", expandedForm(12));
        assertEquals("40 + 2", expandedForm(42));
    }

}
