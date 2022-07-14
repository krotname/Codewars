package kyu6;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

//6 https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/java

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        return Stream.of(array1)
                .filter(word -> Stream.of(array2)
                        .anyMatch(bigWord -> bigWord.contains(word)))
                .sorted()
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }

    @Test
    public void test1() {
        String[] a = new String[]{"arp", "live", "strong"};
        String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String[] r = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
}
