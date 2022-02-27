package kyu6;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FindMissingLetter {

    //6 https://www.codewars.com/kata/5839edaa6754d6fec10000a2/solutions/java
    
    private static ArrayList<Character> alphabet = new ArrayList<>();

    {
        for (char a = 'a'; a <= 'z'; a++) {
            alphabet.add(a);
        }
    }

    public static char findMissingLetter(char[] array) {

        int indexStart = alphabet.indexOf(Character.toLowerCase(array[0]));
        for (int i = 0; i < array.length; i++) {
            if (!alphabet.get(i + indexStart).equals(Character.toLowerCase(array[i])))
                return array[0] > 96 ? alphabet.get(i + indexStart) : Character.toUpperCase(alphabet.get(i + indexStart));
        }
        return ' ';
    }

    @Test
    public void exampleTests() {
        assertEquals('e', FindMissingLetter.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', FindMissingLetter.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }

}
