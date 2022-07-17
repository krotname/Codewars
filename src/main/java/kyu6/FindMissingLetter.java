package kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMissingLetter {

    //6 https://www.codewars.com/kata/5839edaa6754d6fec10000a2/solutions/java

    private static final int A = 96;
    private static final ArrayList<Character> ALPHABET = new ArrayList<>();

    {
        for (char a = 'a'; a <= 'z'; a++) {
            ALPHABET.add(a);
        }
    }

    public static char findMissingLetter(char[] array) {

        int indexStart = ALPHABET.indexOf(Character.toLowerCase(array[0]));
        for (int i = 0; i < array.length; i++) {
            if (!ALPHABET.get(i + indexStart).equals(Character.toLowerCase(array[i])))
                return array[0] >= A ? ALPHABET.get(i + indexStart) : Character.toUpperCase(ALPHABET.get(i + indexStart));
        }
        return ' ';
    }

    @Test
    public void test() {
        assertEquals('e', FindMissingLetter.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', FindMissingLetter.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }

}
