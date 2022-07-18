package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Maskify {

    //7 https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java

    public static String maskify(String str) {
        if (str.length() < 5) return str;
        return "#".repeat(str.length() - 4) + str.substring(str.length() - 4);
    }

    @Test
    public void testSolution() {
        assertEquals("############5616", Maskify.maskify("4556364607935616"));
        assertEquals("#######5616", Maskify.maskify("64607935616"));
        assertEquals("1", Maskify.maskify("1"));
        assertEquals("", Maskify.maskify(""));

        assertEquals("##ippy",
                Maskify.maskify("Skippy"));
        assertEquals("####################################man!",
                Maskify.maskify("Nananananananananananananananana Batman!"));
    }
}
