package kyu7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ListFiltering {

    //7 https://www.codewars.com/kata/53dbd5315a3c69eed20002dd/train/java

    public static List filterList(final List list) {
        return list.stream()
                .filter(o -> o instanceof Integer)
                .mapToInt(num -> (int) num)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    public void examples() {
        // assertEquals("expected", "actual");
        assertEquals(Arrays.asList(1, 2), ListFiltering.filterList(Arrays.asList(1, 2, "a", "b")));
        assertEquals(Arrays.asList(1, 0, 15), ListFiltering.filterList(Arrays.asList(1, "a", "b", 0, 15)));
        assertEquals(Arrays.asList(1, 2, 123), ListFiltering.filterList(Arrays.asList(1, 2, "aasf", "1", "123", 123)));
    }

}
