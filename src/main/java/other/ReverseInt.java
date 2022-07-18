package other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseInt {

    public static int reverse(int x) {
        if (x >= 0) {
            return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
        } else {
            return Integer.parseInt(new StringBuilder(String.valueOf(x).substring(1)).reverse().toString()) * -1;
        }
    }

    @Test
    public void test() {
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
        assertEquals(21, reverse(12));
        assertEquals(1, reverse(012)); // Octal
        assertEquals(0, reverse(0));
    }
}
