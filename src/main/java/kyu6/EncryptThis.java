package kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptThis {

    //6 https://www.codewars.com/kata/5848565e273af816fb000449/train/java

    @Test
    public void exampleTests() {
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", EncryptThis.encryptThis("A wise old owl lived in an oak"));
        assertEquals("119esi 111dl 111lw 108dvei 105n 97n 111ka", EncryptThis.encryptThis("wise old owl lived in an oak"));
        assertEquals("", EncryptThis.encryptThis(""));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", EncryptThis.encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", EncryptThis.encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", EncryptThis.encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", EncryptThis.encryptThis("Thank you Piotr for all your help"));
    }

    public static String encryptThis(String text) {
        if (text == null || text.isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = text.trim().split(" ");
        System.out.println(Arrays.toString(split));
        for (String s : split) {
            String res = "";
            if (s.length() == 1) {
                res = String.valueOf((int) s.toCharArray()[0]);
            } else if (s.length() == 2) {
                res = String.valueOf((int) s.toCharArray()[0]) + s.charAt(1);
            } else {
                int s1 = s.substring(0, 1).toCharArray()[0];
                String s2 = s.substring(1, 2);
                String sLast = s.substring(s.length() - 1);
                res = s1 + sLast + s.substring(2, s.length() - 1) + s2;
            }
            stringBuilder.append(res).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
