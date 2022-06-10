package kyu6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CamelCase {

    //6 https://www.codewars.com/kata/5208f99aee097e6552000148/train/java

    public static String fromCamelCase(String input) {
        if (input == null || input.isEmpty()) return "";
        char[] chars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars[0]);
        for (int i = 0; i < input.length() - 1; i++) {
            if (chars[i + 1] > 64 && chars[i + 1] < 91) { // ASCI
                stringBuilder.append(" ");
            }
            stringBuilder.append(chars[i + 1]);
        }
        return stringBuilder.toString();
    }

    public static String toCamelCase(String str) {
        return Arrays.stream(str.split(" "))
                .filter(s -> s.length() > 0)
                .map(s -> s.replaceFirst(s.substring(0,1), s.substring(0,1).toUpperCase(Locale.ROOT)))
                .collect(Collectors.joining()).trim();
    }

    @Test
    public void tests() {
        assertEquals("Incorrect", "camel Casing", CamelCase.fromCamelCase("camelCasing"));
        assertEquals("Incorrect", "camel Casing Test", CamelCase.fromCamelCase("camelCasingTest"));
        assertEquals("Incorrect", "camelcasingtest", CamelCase.fromCamelCase("camelcasingtest"));
    }

    @Test
    public void testTwoWords() {
        assertEquals("TestCase", CamelCase.toCamelCase("test case"));
    }

    @Test
    public void testThreeWords() {
        assertEquals("CamelCaseMethod", CamelCase.toCamelCase("camel case method"));
    }

    @Test
    public void testLeadingSpace() {
        assertEquals("CamelCaseWord", CamelCase.toCamelCase(" camel case word"));
    }

    @Test
    public void testTrailingSpace() {
        assertEquals("SayHello", CamelCase.toCamelCase("say hello "));
    }

    @Test
    public void testSingleLetter() {
        assertEquals("Z", CamelCase.toCamelCase("z"));
    }

}
