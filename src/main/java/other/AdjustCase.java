package other;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AdjustCase {

    private final static String SUN_CORRECT = "Солнце";
    private final static String SUN_INCORRECT1 = "сОЛнЦЕ";
    private final static String SUN_INCORRECT2 = "солнцЕ";
    private final static String SUN_INCORRECT3 = "солнце";
    private final static String SUN_INCORRECT4 = "СОЛНЦЕ";
    private final static String SUN_INCORRECT5 = "сО";
    private final static String SUN_INCORRECT6 = "С";
    public static final String CO = "Со";
    public static final String C = "С";
    public static final String EMPTY = "";

    public String adjustCaseToLower(String string) {
        if (string == null || string.length() == 0) return string;
        if (string.length() == 1) return string.toUpperCase();
        var stringLover = string.toLowerCase(Locale.ROOT).substring(1);
        var firstChar = string.substring(0, 1).toUpperCase(Locale.ROOT);
        return firstChar + stringLover;
    }

    public String adjustCaseStream(String string) {
        if (string == null || string.length() == 0) return string;
        var lower = string.chars()
                .mapToObj(i -> (char) i)
                .map(Object::toString)
                .map(String::toLowerCase)
                .collect(Collectors.joining())
                .substring(1);
        return string.chars()
                .mapToObj(i -> (char) i)
                .map(Object::toString)
                .findFirst()
                .orElse("")
                .toUpperCase() + lower;
    }

    public String adjustCaseFor(String string) {
        if (string == null) return null;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i == 0) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
            else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }


    @Test
    public void testAdjustCaseToLower() {
        assertEquals(SUN_CORRECT, adjustCaseToLower(SUN_INCORRECT1));
        assertEquals(SUN_CORRECT, adjustCaseToLower(SUN_INCORRECT2));
        assertEquals(SUN_CORRECT, adjustCaseToLower(SUN_INCORRECT3));
        assertEquals(SUN_CORRECT, adjustCaseToLower(SUN_INCORRECT4));
        assertEquals(CO, adjustCaseToLower(SUN_INCORRECT5));
        assertEquals(C, adjustCaseToLower(SUN_INCORRECT6));
        assertEquals(EMPTY, adjustCaseToLower(EMPTY));
        assertNull(adjustCaseToLower(null));
    }

    @Test
    public void testAdjustCaseStream() {
        assertEquals(SUN_CORRECT, adjustCaseStream(SUN_INCORRECT1));
        assertEquals(SUN_CORRECT, adjustCaseStream(SUN_INCORRECT2));
        assertEquals(SUN_CORRECT, adjustCaseStream(SUN_INCORRECT3));
        assertEquals(SUN_CORRECT, adjustCaseStream(SUN_INCORRECT4));
        assertEquals(CO, adjustCaseStream(SUN_INCORRECT5));
        assertEquals(C, adjustCaseStream(SUN_INCORRECT6));
        assertEquals(EMPTY, adjustCaseStream(EMPTY));
        assertNull(adjustCaseStream(null));
    }

    @Test
    public void testAdjustCaseFor() {
        assertEquals(SUN_CORRECT, adjustCaseFor(SUN_INCORRECT1));
        assertEquals(SUN_CORRECT, adjustCaseFor(SUN_INCORRECT2));
        assertEquals(SUN_CORRECT, adjustCaseFor(SUN_INCORRECT3));
        assertEquals(SUN_CORRECT, adjustCaseFor(SUN_INCORRECT4));
        assertEquals(CO, adjustCaseFor(SUN_INCORRECT5));
        assertEquals(C, adjustCaseFor(SUN_INCORRECT6));
        assertEquals(EMPTY, adjustCaseFor(EMPTY));
        assertNull(adjustCaseFor(null));
    }

}
