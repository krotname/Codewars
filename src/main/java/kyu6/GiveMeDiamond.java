package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GiveMeDiamond {

    //6 https://www.codewars.com/kata/5503013e34137eeeaa001648/train/java

    public static String print(int n) {
        if (n % 2 == 0 || n < 1) return null;
        int count = n / 2 + 1;
        StringBuilder strings = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            strings.append(" ".repeat(count - i)).append("*".repeat(i * 2 - 1)).append("\n");
        }
        for (int i = count - 1; i >= 1; i--) {
            strings.append(" ".repeat(count - i)).append("*".repeat(i * 2 - 1)).append("\n");
        }
        return strings.toString();
    }


    @Test
    public void testGiveMeDiamondttt() {
        System.out.println(GiveMeDiamond.print(5));
    }

    @Test
    public void testGiveMeDiamond3() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");

        assertEquals(expected.toString(), GiveMeDiamond.print(3));
    }

    @Test
    public void testGiveMeDiamond5() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        assertEquals(expected.toString(), GiveMeDiamond.print(5));
    }

    @Test
    public void testGiveMeDiamond1() {
        StringBuffer expected = new StringBuffer();
        expected.append("*\n");
        assertEquals(expected.toString(), GiveMeDiamond.print(1));
    }

    @Test
    public void testGiveMeDiamond0() {
        assertEquals(null, GiveMeDiamond.print(0));
    }

    @Test
    public void testGiveMeDiamondMinus2() {
        assertEquals(null, GiveMeDiamond.print(-2));
    }

    @Test
    public void testGiveMeDiamond2() {
        assertEquals(null, GiveMeDiamond.print(2));
    }

}
