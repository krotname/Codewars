package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWords {

    public static String reverseWords(final String original) {
        if (original.matches("\\s+")) return original;
        StringBuilder stringBuilder = new StringBuilder();
        String[] s = original.split("\\s");
        for (String s1 : s
        ) {
            stringBuilder.append(new StringBuilder(s1).reverse()).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    @Test
    public void test() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("   ", reverseWords("   "));
    }
}
