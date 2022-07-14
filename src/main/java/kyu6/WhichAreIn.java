package kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WhichAreIn {

    //6 https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/java

    public static String[] inArray(String[] array1, String[] array2) {
        return Stream.of(array1)
                .filter(word -> Stream.of(array2)
                        .anyMatch(bigWord -> bigWord.contains(word)))
                .sorted().toList()
                .toArray(String[]::new);
    }

    @Test
    public void testWhichAreIn() {
        String[] a = new String[]{"arp", "live", "strong"};
        String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String[] r = new String[]{"arp", "live", "strong"};
        assertArrayEquals(r, inArray(a, b));
    }
}
