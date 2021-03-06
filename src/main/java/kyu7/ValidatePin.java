package kyu7;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatePin {
    // 7 https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/train/java

    public static boolean validatePin(String pin) {
        return Pattern.compile("[\\d]{4}|[\\d]{6}").matcher(pin).matches();
    }

    @Test
    public void validPins() {
        assertTrue(validatePin("1234"));
        assertTrue(validatePin("0000"));
        assertTrue(validatePin("1111"));
        assertTrue(validatePin("123456"));
        assertTrue(validatePin("098765"));
        assertTrue(validatePin("000000"));
        assertTrue(validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertFalse(validatePin("a234"));
        assertFalse(validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertFalse(validatePin("1"));
        assertFalse(validatePin("12"));
        assertFalse(validatePin("123"));
        assertFalse(validatePin("12345"));
        assertFalse(validatePin("1234567"));
        assertFalse(validatePin("-1234"));
        assertFalse(validatePin("1.234"));
        assertFalse(validatePin("00000000"));
    }
}
