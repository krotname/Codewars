package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListFiltering {

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
        assertEquals(Arrays.asList(new Object[]{1, 2}), ListFiltering.filterList(Arrays.asList(new Object[]{1, 2, "a", "b"})));
        assertEquals(Arrays.asList(new Object[]{1, 0, 15}), ListFiltering.filterList(Arrays.asList(new Object[]{1, "a", "b", 0, 15})));
        assertEquals(Arrays.asList(new Object[]{1, 2, 123}), ListFiltering.filterList(Arrays.asList(new Object[]{1, 2, "aasf", "1", "123", 123})));
    }

}
