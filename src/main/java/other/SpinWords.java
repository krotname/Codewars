package other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Разворачивает каждое слово в предложении

public class SpinWords {

    public String spinWords(String sentence) {
        String[] arrWords = sentence.split("\\s");
        StringBuilder resultSb = new StringBuilder();
        for (String curentWord : arrWords
        ) {
            if (curentWord.length() >= 5) {
                StringBuilder curentSb = new StringBuilder(curentWord);
                resultSb.append(curentSb.reverse());
            } else {
                resultSb.append(curentWord);
            }
            resultSb.append(" ");
        }
        return resultSb.toString().trim();
    }

    @Test
    public void test() {
        assertEquals(spinWords("Welcome"), "emocleW");
        assertEquals(spinWords("Hey fellow warriors"), "Hey wollef sroirraw");
    }
}
