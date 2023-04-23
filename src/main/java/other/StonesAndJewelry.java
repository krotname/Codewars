package other;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StonesAndJewelry {
    private final static String JEWELRY = "ab";
    private final static String STONES = "aabbccd";

    public static final String EMPTY = "";


    public int calculate(String jewelry, String stones) {
        if (Objects.isNull(jewelry) || Objects.isNull(stones)) return 0;
        var setJewelry = jewelry
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        char[] stonesChars = stones.toCharArray();
        int count = 0;
        for (char stonesChar : stonesChars) {
            if (setJewelry.contains(stonesChar)) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(4, calculate(JEWELRY, STONES));
        assertEquals(0, calculate(EMPTY, EMPTY));
        assertEquals(0, calculate(null, null));
    }
}
