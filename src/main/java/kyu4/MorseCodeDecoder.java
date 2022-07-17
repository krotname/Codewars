package kyu4;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeDecoder {

    //4 https://www.codewars.com/kata/54b72c16cd7f5154e9000457
    //6 https://www.codewars.com/kata/54b724efac3d5402db00065e

    private static final Map<String, String> ALPHABET_TO_MORSE = new LinkedHashMap<>();
    private static final Map<String, String> MORSE_TO_ALPHABET = new LinkedHashMap<>();
    private static final int ASCII_0 = 48;
    private static final int ASCII_1 = 49;

    static {
        ALPHABET_TO_MORSE.put("a", ".-");
        ALPHABET_TO_MORSE.put("b", "-...");
        ALPHABET_TO_MORSE.put("c", "-.-.");
        ALPHABET_TO_MORSE.put("d", "-..");
        ALPHABET_TO_MORSE.put("e", ".");
        ALPHABET_TO_MORSE.put("f", "..-.");
        ALPHABET_TO_MORSE.put("g", "--.");
        ALPHABET_TO_MORSE.put("h", "....");
        ALPHABET_TO_MORSE.put("i", "..");
        ALPHABET_TO_MORSE.put("j", ".---");
        ALPHABET_TO_MORSE.put("k", "-.-");
        ALPHABET_TO_MORSE.put("l", ".-..");
        ALPHABET_TO_MORSE.put("m", "--");
        ALPHABET_TO_MORSE.put("n", "-.");
        ALPHABET_TO_MORSE.put("o", "---");
        ALPHABET_TO_MORSE.put("p", ".--.");
        ALPHABET_TO_MORSE.put("q", "--.-");
        ALPHABET_TO_MORSE.put("r", ".-.");
        ALPHABET_TO_MORSE.put("s", "...");
        ALPHABET_TO_MORSE.put("t", "-");
        ALPHABET_TO_MORSE.put("u", "..-");
        ALPHABET_TO_MORSE.put("v", "...-");
        ALPHABET_TO_MORSE.put("w", ".--");
        ALPHABET_TO_MORSE.put("x", "-..-");
        ALPHABET_TO_MORSE.put("y", "-.--");
        ALPHABET_TO_MORSE.put("z", "--..");
        ALPHABET_TO_MORSE.put("1", ".----");
        ALPHABET_TO_MORSE.put("2", "..---");
        ALPHABET_TO_MORSE.put("3", "...--");
        ALPHABET_TO_MORSE.put("4", "....-");
        ALPHABET_TO_MORSE.put("5", ".....");
        ALPHABET_TO_MORSE.put("6", "-....");
        ALPHABET_TO_MORSE.put("7", "--...");
        ALPHABET_TO_MORSE.put("8", "---..");
        ALPHABET_TO_MORSE.put("9", "----.");
        ALPHABET_TO_MORSE.put("0", "-----");
        ALPHABET_TO_MORSE.put(" ", "   ");

        MORSE_TO_ALPHABET.put("a", "b");
        MORSE_TO_ALPHABET.put("c", "d");
        MORSE_TO_ALPHABET.put("-.-.-.", ";");
        MORSE_TO_ALPHABET.put("-...-", "=");
        MORSE_TO_ALPHABET.put("---", "O");
        MORSE_TO_ALPHABET.put("----.", "9");
        MORSE_TO_ALPHABET.put("-..-.", "/");
        MORSE_TO_ALPHABET.put(".-...", "&");
        MORSE_TO_ALPHABET.put("...--", "3");
        MORSE_TO_ALPHABET.put(".--", "W");
        MORSE_TO_ALPHABET.put("--", "M");
        MORSE_TO_ALPHABET.put("--..", "Z");
        MORSE_TO_ALPHABET.put(".----.", "'");
        MORSE_TO_ALPHABET.put("-.-.--", "!");
        MORSE_TO_ALPHABET.put("-...", "B");
        MORSE_TO_ALPHABET.put("..-", "U");
        MORSE_TO_ALPHABET.put(".----", "1");
        MORSE_TO_ALPHABET.put("-.--.-", ")");
        MORSE_TO_ALPHABET.put(".-", "A");
        MORSE_TO_ALPHABET.put("-....-", "-");
        MORSE_TO_ALPHABET.put("...-", "V");
        MORSE_TO_ALPHABET.put("...---...", "SOS");
        MORSE_TO_ALPHABET.put("-.--", "Y");
        MORSE_TO_ALPHABET.put("..", "I");
        MORSE_TO_ALPHABET.put("--.-", "Q");
        MORSE_TO_ALPHABET.put("-.", "N");
        MORSE_TO_ALPHABET.put("..---", "2");
        MORSE_TO_ALPHABET.put("-....", "6");
        MORSE_TO_ALPHABET.put("---...", ";");
        MORSE_TO_ALPHABET.put(".-.-.", "+");
        MORSE_TO_ALPHABET.put(".--.-.", "@");
        MORSE_TO_ALPHABET.put("....-", "4");
        MORSE_TO_ALPHABET.put("-----", "0");
        MORSE_TO_ALPHABET.put(".-.-.-", ".");
        MORSE_TO_ALPHABET.put("-.-.", "C");
        MORSE_TO_ALPHABET.put(".", "E");
        MORSE_TO_ALPHABET.put("..-.", "F");
        MORSE_TO_ALPHABET.put(".---", "J");
        MORSE_TO_ALPHABET.put("-.-", "K");
        MORSE_TO_ALPHABET.put(".-..", "L");
        MORSE_TO_ALPHABET.put(".-.", "R");
        MORSE_TO_ALPHABET.put("...", "S");
        MORSE_TO_ALPHABET.put("--.", "G");
        MORSE_TO_ALPHABET.put("---..", "8");
        MORSE_TO_ALPHABET.put("..--..", "?");
        MORSE_TO_ALPHABET.put("-.--.", "(");
        MORSE_TO_ALPHABET.put(".--.", "P");
        MORSE_TO_ALPHABET.put(".....", "5");
        MORSE_TO_ALPHABET.put("..--.-", "_");
        MORSE_TO_ALPHABET.put("-..", "D");
        MORSE_TO_ALPHABET.put(".-..-.", "\"");
        MORSE_TO_ALPHABET.put("-", "T");
        MORSE_TO_ALPHABET.put("....", "H");
        MORSE_TO_ALPHABET.put("--..--", ",");
        MORSE_TO_ALPHABET.put("...-..-", "$");
        MORSE_TO_ALPHABET.put("--...", "7");
        MORSE_TO_ALPHABET.put("-..-", "X");
        MORSE_TO_ALPHABET.put("", " ");
    }

    public static String decodeMorse(String morseCode) {
        String[] split = morseCode.split("\\s");
        StringBuilder result = new StringBuilder();
        for (String s : split
        ) {
            String s1 = MORSE_TO_ALPHABET.get(s);
            if (!s1.equals(" ") || !result.toString().endsWith(s1)) {
                result.append(s1);
            }
        }
        return result.toString().toUpperCase().trim();
    }

    public static String encode(String toMorseCode) {
        char[] chars = toMorseCode.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char s : chars
        ) {
            String currentChar = String.valueOf(s).toLowerCase();
            result.append(ALPHABET_TO_MORSE.get(currentChar)).append(" ");
        }
        return result.toString().toUpperCase().trim();
    }

    public static String decodeBits(String bits) {
        bits = trimStartZeros(bits);
        int digits = checkDigits(bits);
        char[] chars = bits.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bits.length(); i += digits) {
            stringBuilder.append(chars[i]);
        }
        stringBuilder.append("0000000");
        StringBuilder result = new StringBuilder();
        char[] chars1digits = stringBuilder.toString().toCharArray();
        for (int i = 0; i < chars1digits.length - 6; i++) {
            if (chars1digits[i] == ASCII_1) {
                if (chars1digits[i + 1] == ASCII_1 && chars1digits[i + 2] == ASCII_1) {
                    result.append("-");
                    i += 2;
                } else {
                    result.append(".");
                }
            }
            if (chars1digits[i] == ASCII_0) {
                if (chars1digits[i + 1] == ASCII_0 && chars1digits[i + 2] == ASCII_0 && chars1digits[i + 3] == ASCII_0 && chars1digits[i + 4] == ASCII_0 && chars1digits[i + 5] == ASCII_0 && chars1digits[i + 6] == ASCII_0) {
                    result.append("   ");
                    i += 6;
                } else if (chars1digits[i + 1] == ASCII_0 && chars1digits[i + 2] == ASCII_0) {
                    result.append(" ");
                }
            }
        }
        return result.toString().trim();
    }

    public static String trimStartZeros(String bits) {
        while (bits.startsWith("0")) {
            bits = bits.substring(1);
        }
        return bits;
    }

    public static int checkDigits(String bits) {
        int minCount1 = Integer.MAX_VALUE;
        int minCount0 = Integer.MAX_VALUE;
        int count1 = 0;
        int count0 = 0;
        char[] chars = bits.toCharArray();
        for (int i = 0; i < bits.length(); i++) {
            if (chars[i] == ASCII_1) {
                count1++;
            } else {
                if (count1 > 0) {
                    minCount1 = Math.min(count1, minCount1);
                }
                count1 = 0;
            }
            if (chars[i] == ASCII_0) {
                count0++;
            } else {
                if (count0 > 0) {
                    minCount0 = Math.min(count0, minCount0);
                }
                count0 = 0;
            }
        }
        return Math.min(minCount0, minCount1);
    }

    @Test
    public void testDecodeMorse() {
        assertEquals("HEY JUDE",
                decodeMorse(".... . -.--   .--- ..- -.. ."));
        assertEquals("SOS THE QUICK BROWN FO JUMPS OVER THE LAZY DOG",
                decodeMorse("... --- ...     - .... .     --.- ..- .. -.-. -.-     -... .-. --- .-- -.     ..-. ---     .--- ..- -- .--. ...     --- ...- . .-.     - .... .     .-.. .- --.. -.--     -.. --- --."));
    }

    @Test
    public void testEncode() {
        assertEquals("... --- ...     - .... .     --.- ..- .. -.-. -.-     -... .-. --- .-- -.     ..-. ---     .--- ..- -- .--. ...     --- ...- . .-.     - .... .     .-.. .- --.. -.--     -.. --- --.",
                encode("SOS THE QUICK BROWN FO JUMPS OVER THE LAZY DOG"));
        assertEquals("... --- ...",
                encode("SOS"));
    }

    @Test
    public void testDecodeBits() {
        assertEquals("----..",
                decodeBits("111111011111111"));
        assertEquals(".... . -.--   .--- ..- -.. .",
                decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"));
    }

    @Test
    public void testComplex() {
        assertEquals("H",
                decodeMorse(decodeBits("11011")));
        assertEquals("HEY JUDE",
                decodeMorse(decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")));
    }

}
