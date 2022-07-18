package kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineNumbering {

    //7 https://www.codewars.com/kata/54bf85e3d5b56c7a05000cf9/train/java

    public static List<String> number(List<String> lines) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            arrayList.add(i + 1 + ": " + lines.get(i));
        }
        return arrayList;
    }

    @Test
    public void basicTests() {
        assertEquals(List.of(),
                LineNumbering.number(List.of()));
        assertEquals(Arrays.asList("1: a", "2: b", "3: c"),
                LineNumbering.number(Arrays.asList("a", "b", "c")));
        assertEquals(Arrays.asList("1: ", "2: ", "3: ", "4: ", "5: "),
                LineNumbering.number(Arrays.asList("", "", "", "", "")));
    }
}
