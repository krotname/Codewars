package kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmileFaces {

    private static final Set<String> SMILE_FACES = Set.of(
            ":)", ":D", ":-)", ":-D", ":~)", ":~D",
            ";)", ";D", ";-)", ";-D", ";~)", ";~D");

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream().filter(SMILE_FACES::contains).count();
    }

    @Test
    public void test1() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add(":-}");
        a.add(":-()");
        assertEquals(2, SmileFaces.countSmileys(a));
    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add("XD");
        a.add(":0}");
        a.add("x:-");
        a.add("):-");
        a.add("D:");
        assertEquals(1, SmileFaces.countSmileys(a));
    }

    @Test
    public void test4() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add("X-}");
        a.add("xo)");
        a.add(":X");
        a.add(":-3");
        a.add(":3");
        assertEquals(2, SmileFaces.countSmileys(a));
    }

    @Test
    public void test5() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":)");
        a.add("x-]");
        a.add(":ox");
        a.add(";-(");
        a.add(";-)");
        a.add(";~(");
        a.add(":~D");
        assertEquals(4, SmileFaces.countSmileys(a));
    }

}
