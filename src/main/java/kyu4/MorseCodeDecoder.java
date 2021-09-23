package kyu4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MorseCodeDecoder {

    //6 https://www.codewars.com/kata/54b724efac3d5402db00065e
    //4 https://www.codewars.com/kata/54b72c16cd7f5154e9000457/train/java

    private static LinkedHashMap<String, String> alphabetToMorse = new LinkedHashMap<>();

    static Map<String, String> morseMap = new HashMap<>() {{
        put("a", "b");
        put("c", "d");
        put("-.-.-.", ";");
        put("-...-", "=");
        put("---", "O");
        put("----.", "9");
        put("-..-.", "/");
        put(".-...", "&");
        put("...--", "3");
        put(".--", "W");
        put("--", "M");
        put("--..", "Z");
        put(".----.", "'");
        put("-.-.--", "!");
        put("-...", "B");
        put("..-", "U");
        put(".----", "1");
        put("-.--.-", ")");
        put(".-", "A");
        put("-....-", "-");
        put("...-", "V");
        put("...---...", "SOS");
        put("-.--", "Y");
        put("..", "I");
        put("--.-", "Q");
        put("-.", "N");
        put("..---", "2");
        put("-....", "6");
        put("---...", ";");
        put(".-.-.", "+");
        put(".--.-.", "@");
        put("....-", "4");
        put("-----", "0");
        put(".-.-.-", ".");
        put("-.-.", "C");
        put(".", "E");
        put("..-.", "F");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put(".-.", "R");
        put("...", "S");
        put("--.", "G");
        put("---..", "8");
        put("..--..", "?");
        put("-.--.", "(");
        put(".--.", "P");
        put(".....", "5");
        put("..--.-", "_");
        put("-..", "D");
        put(".-..-.", "\"");
        put("-", "T");
        put("....", "H");
        put("--..--", ",");
        put("...-..-", "$");
        put("--...", "7");
        put("-..-", "X");
        put("", " ");
    }};

    static {
        alphabetToMorse.put("a", ".-");
        alphabetToMorse.put("b", "-...");
        alphabetToMorse.put("c", "-.-.");
        alphabetToMorse.put("d", "-..");
        alphabetToMorse.put("e", ".");
        alphabetToMorse.put("f", "..-.");
        alphabetToMorse.put("g", "--.");
        alphabetToMorse.put("h", "....");
        alphabetToMorse.put("i", "..");
        alphabetToMorse.put("j", ".---");
        alphabetToMorse.put("k", "-.-");
        alphabetToMorse.put("l", ".-..");
        alphabetToMorse.put("m", "--");
        alphabetToMorse.put("n", "-.");
        alphabetToMorse.put("o", "---");
        alphabetToMorse.put("p", ".--.");
        alphabetToMorse.put("q", "--.-");
        alphabetToMorse.put("r", ".-.");
        alphabetToMorse.put("s", "...");
        alphabetToMorse.put("t", "-");
        alphabetToMorse.put("u", "..-");
        alphabetToMorse.put("v", "...-");
        alphabetToMorse.put("w", ".--");
        alphabetToMorse.put("x", "-..-");
        alphabetToMorse.put("y", "-.--");
        alphabetToMorse.put("z", "--..");
        alphabetToMorse.put("1", ".----");
        alphabetToMorse.put("2", "..---");
        alphabetToMorse.put("3", "...--");
        alphabetToMorse.put("4", "....-");
        alphabetToMorse.put("5", ".....");
        alphabetToMorse.put("6", "-....");
        alphabetToMorse.put("7", "--...");
        alphabetToMorse.put("8", "---..");
        alphabetToMorse.put("9", "----.");
        alphabetToMorse.put("0", "-----");
        alphabetToMorse.put(" ", "   ");
    }

    public static void main(String[] args) {
        System.out.println(decodeMorse(".... . -.--   .--- ..- -.. ."));
        System.out.println(decodeMorse(".... . -.--   .--- ..- -.. ."));
        System.out.println(encode("SOS THE QUICK BROWN FO JUMPS OVER THE LAZY DOG"));
        System.out.println(decodeMorse("... --- ...     - .... .     --.- ..- .. -.-. -.-     -... .-. --- .-- -.     ..-. ---     .--- ..- -- .--. ...     --- ...- . .-.     - .... .     .-.. .- --.. -.--     -.. --- --."));
        System.out.println(decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"));
        System.out.println(decodeMorse(decodeBits("11011")));
        System.out.println(decodeBits("111111011111111"));
        System.out.println(decodeMorse(decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")));
    }

    public static String decodeMorse(String morseCode) {
        String[] split = morseCode.split("\\s");
        StringBuilder result = new StringBuilder();
        for (String s : split
        ) {
            String s1 = morseMap.get(s);
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
            String s1 = String.valueOf(s).toLowerCase();
            result.append(alphabetToMorse.get(s1)).append(" ");
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
            if (chars1digits[i] == 49) { // ASCI 1
                if (chars1digits[i + 1] == 49 && chars1digits[i + 2] == 49) {
                    result.append("-");
                    i += 2;
                } else {
                    result.append(".");
                }
            }
            if (chars1digits[i] == 48) { // ASCI 0
                if (chars1digits[i + 1] == 48 && chars1digits[i + 2] == 48 && chars1digits[i + 3] == 48 && chars1digits[i + 4] == 48 && chars1digits[i + 5] == 48 && chars1digits[i + 6] == 48) {
                    result.append("   ");
                    i += 6;
                } else if (chars1digits[i + 1] == 48 && chars1digits[i + 2] == 48) {
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
            if (chars[i] == 49) { //ASCI = 1
                count1++;
            } else {
                if (count1 > 0) {
                    minCount1 = Math.min(count1, minCount1);
                }
                count1 = 0;
            }
            if (chars[i] == 48) { //ASCI = 0
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

}