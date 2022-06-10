package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CamelCase {

    //6 https://www.codewars.com/kata/5208f99aee097e6552000148/train/java

    public static String camelCase(String input) {
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

    @Test
    public void tests() {
        assertEquals("Incorrect", "camel Casing", CamelCase.camelCase("camelCasing"));
        assertEquals("Incorrect", "camel Casing Test", CamelCase.camelCase("camelCasingTest"));
        assertEquals("Incorrect", "camelcasingtest", CamelCase.camelCase("camelcasingtest"));
    }

}
