package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareDigit {

    //7 https://www.codewars.com/kata/546e2562b03326a88e000020/train/java

    @Test
    public void test() {
        assertEquals(811181, squareDigits(9119));
        assertEquals(0, squareDigits(0));
        assertEquals(1, squareDigits(-1));
    }

    public static int squareDigits(int n) {
        if (n == 0) return 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int i = n % 10;
            n /= 10;
            stringBuilder.insert(0, i * i);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
