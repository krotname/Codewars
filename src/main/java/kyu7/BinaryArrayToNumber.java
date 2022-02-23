package kyu7;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class BinaryArrayToNumber {
    //7 https://www.codewars.com/kata/578553c3a1b8d5c40300037c

    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt(Arrays.asList(1, 1, 1, 1)));
        System.out.println(ConvertBinaryArrayToInt(Arrays.asList(1, 0, 1, 1)));
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : binary
        ) {
            stringBuilder.append(i);
        }
        BigInteger bigInteger = new BigInteger(stringBuilder.toString(), 2);
        return bigInteger.intValue();
    }
}
