package kyu6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MorseCodeDecoder {

    //7 https://www.codewars.com/kata/54b724efac3d5402db00065e
    
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
        System.out.println(decode(".... . -.--   .--- ..- -.. ."));
        System.out.println(decode("...-- -..."));
        System.out.println(encode("SOS THE QUICK BROWN FO JUMPS OVER THE LAZY DOG"));
        System.out.println(decode("... --- ...     - .... .     --.- ..- .. -.-. -.-     -... .-. --- .-- -.     ..-. ---     .--- ..- -- .--. ...     --- ...- . .-.     - .... .     .-.. .- --.. -.--     -.. --- --."));
    }

    public static String decode(String morseCode) {
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
}
