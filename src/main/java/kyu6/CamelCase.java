package kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CamelCase {

    //6 https://www.codewars.com/kata/5208f99aee097e6552000148/train/java
    //6 https://www.codewars.com/kata/587731fda577b3d1b0001196/train/java

    private static final int A = 65; // ASCII
    private static final int Z = 90; // ASCII

    @Test
    public void testsFromCamelCase() {
        assertEquals("Incorrect", "camel Casing", fromCamelCase("camelCasing"));
        assertEquals("Incorrect", "camel Casing Test", fromCamelCase("camelCasingTest"));
        assertEquals("Incorrect", "camelcasingtest", fromCamelCase("camelcasingtest"));
    }

    @Test
    public void testToCamelCase() {
        assertEquals("TestCase", toCamelCase("test case"));
        assertEquals("CamelCaseMethod", toCamelCase("camel case method"));
        assertEquals("CamelCaseWord", toCamelCase(" camel case word"));
        assertEquals("SayHello", toCamelCase("say hello "));
        assertEquals("Z", toCamelCase("z"));
    }

    public static String fromCamelCase(String input) {
        if (input == null || input.isEmpty()) return "";
        char[] chars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars[0]);
        for (int i = 0; i < input.length() - 1; i++) {
            if (chars[i + 1] >= A && chars[i + 1] <= Z) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(chars[i + 1]);
        }
        return stringBuilder.toString();
    }

    public static String toCamelCase(String str) {
        return Arrays.stream(str.split(" "))
                .filter(s -> s.length() > 0)
                .map(s -> s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase(Locale.ROOT)))
                .collect(Collectors.joining()).trim();
    }

}
