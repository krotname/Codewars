package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GiveMeDiamond {

    //6 https://www.codewars.com/kata/5503013e34137eeeaa001648/train/java

    @Test
    public void testGiveMeDiamond1() {
        assertEquals("*" + System.lineSeparator(), GiveMeDiamond.print(1));
    }

    @Test
    public void testGiveMeDiamond3() {
        var e = " *" + System.lineSeparator() +
                "***" + System.lineSeparator() +
                " *" + System.lineSeparator();

        assertEquals(e, GiveMeDiamond.print(3));
    }

    @Test
    public void testGiveMeDiamond5() {
        var e = "  *" + System.lineSeparator() +
                " ***" + System.lineSeparator() +
                "*****" + System.lineSeparator() +
                " ***" + System.lineSeparator() +
                "  *" + System.lineSeparator();

        assertEquals(e, GiveMeDiamond.print(5));
    }

    @Test
    public void testGiveMeDiamondNull() {
        assertNull(GiveMeDiamond.print(0));
        assertNull(GiveMeDiamond.print(-2));
        assertNull(GiveMeDiamond.print(2));
    }

    public static String print(int n) {
        if (n % 2 == 0 || n < 1) return null;
        int count = n / 2 + 1;
        StringBuilder strings = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            strings.append(" ".repeat(count - i)).append("*".repeat(i * 2 - 1)).append(System.lineSeparator());
        }
        for (int i = count - 1; i >= 1; i--) {
            strings.append(" ".repeat(count - i)).append("*".repeat(i * 2 - 1)).append(System.lineSeparator());
        }
        return strings.toString();
    }

}
