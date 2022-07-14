package kyu7;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryArrayToNumber {
    //7 https://www.codewars.com/kata/578553c3a1b8d5c40300037c

    public static int convertBinaryArrayToInt(List<Integer> binary) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : binary
        ) {
            stringBuilder.append(i);
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.toString(), 2);
        return bigInteger.intValue();
    }

    @Test
    public void test() {
        assertEquals(15, convertBinaryArrayToInt(Arrays.asList(1, 1, 1, 1)));
        assertEquals(11, convertBinaryArrayToInt(Arrays.asList(1, 0, 1, 1)));
    }
}
