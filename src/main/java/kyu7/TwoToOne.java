package kyu7;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoToOne {

    //7 https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/java

    @Test
    public void test() {
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
    }

    public static String longest(String s1, String s2) {
        TreeSet<Character> characters = new TreeSet<>();
        for (char c : s1.toCharArray()) {
            characters.add(c);
        }
        for (char c : s2.toCharArray()) {
            characters.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        return sb.toString();
    }
}
