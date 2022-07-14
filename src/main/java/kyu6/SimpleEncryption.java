package kyu6;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleEncryption {

    private static final String THIS_IS_A_TEST = "This is a test!";

    //6 https://www.codewars.com/SimpleEncryption/57814d79a56c88e3e0000786/train/java

    @Test
    public void testEncrypt() {
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.encrypt(THIS_IS_A_TEST, 0));
        assertEquals("hsi  etTi sats!", SimpleEncryption.encrypt(THIS_IS_A_TEST, 1));
        assertEquals("s eT ashi tist!", SimpleEncryption.encrypt(THIS_IS_A_TEST, 2));
        assertEquals(" Tah itse sits!", SimpleEncryption.encrypt(THIS_IS_A_TEST, 3));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.encrypt(THIS_IS_A_TEST, 4));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.encrypt(THIS_IS_A_TEST, -1));
    }

    @Test
    public void testDecrypt() {
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.decrypt(THIS_IS_A_TEST, 0));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.decrypt("hsi  etTi sats!", 1));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.decrypt("s eT ashi tist!", 2));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.decrypt(" Tah itse sits!", 3));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.decrypt(THIS_IS_A_TEST, 4));
        assertEquals(THIS_IS_A_TEST, SimpleEncryption.decrypt(THIS_IS_A_TEST, -1));
    }

    @Test
    public void testNullOrEmpty() {
        assertEquals("", SimpleEncryption.encrypt("", 0));
        assertEquals("", SimpleEncryption.decrypt("", 0));
        assertNull(SimpleEncryption.encrypt(null, 0));
        assertNull(SimpleEncryption.decrypt(null, 0));
    }

    public static String encrypt(final String text, final int n) {
        if (text == null || text.isEmpty() || n < 1) return text;

        var start = new StringBuilder(text);
        var current = new StringBuilder();
        char[] chars = start.toString().toCharArray();

        for (int j = 1; j < start.length(); j += 2) {
            current.append(chars[j]);
        }
        for (int j = 0; j < start.length(); j += 2) {
            current.append(chars[j]);
        }
        start = new StringBuilder(current);
        return encrypt(start.toString(), n - 1);
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.isEmpty() || n < 1) return encryptedText;

        var start = new StringBuilder(encryptedText);
        var current = new char[start.length()];
        var encryptedList = IntStream.range(0, encryptedText.length())
                .mapToObj(encryptedText::charAt)
                .collect(Collectors.toCollection(LinkedList::new));

        for (int j = 1; j < start.length(); j += 2) {
            current[j] = encryptedList.pollFirst();
        }
        for (int j = 0; j < start.length(); j += 2) {
            current[j] = current[j] = encryptedList.pollFirst();
        }
        start = new StringBuilder(String.valueOf(current));
        return decrypt(start.toString(), n - 1);
    }
}
