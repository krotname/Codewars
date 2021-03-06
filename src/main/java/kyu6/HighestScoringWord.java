package kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestScoringWord {

    //6 https://www.codewars.com/HighestScoringWord/57eb8fcdf670e99d9b000272/train/java

    private static final int ASCII_INT = 96;

    public static String high(String s) {
        return Arrays.stream(s.split("\\s"))
                .max(Comparator.comparingInt(word -> word.chars()
                        .map(c -> Character.toLowerCase(c) - ASCII_INT)
                        .sum()))
                .orElseThrow();
    }

    @Test
    public void sampleTests() {
        assertEquals("taxi", HighestScoringWord.high("man i need a taxi up to ubud"));
        assertEquals("volcano", HighestScoringWord.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", HighestScoringWord.high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", HighestScoringWord.high("aa b"));
        assertEquals("b", HighestScoringWord.high("b aa"));
        assertEquals("bb", HighestScoringWord.high("bb d"));
        assertEquals("d", HighestScoringWord.high("d bb"));
        assertEquals("aaa", HighestScoringWord.high("aaa b"));
    }
}
