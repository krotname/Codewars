package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmstrongNumber {

    // 6 https://www.codewars.com/kata/5287e858c6b5a9678200083c/train/java
    public static boolean isNarcissistic(int number) {
        var result = 0;
        var currentNumber = number;
        var n = numberOfDigits(currentNumber);
        for (var i = 0; i <= n; i++) {
            var currentDig = currentNumber % 10;
            currentNumber /= 10;
            result += Math.pow(currentDig, n);
        }
        return result == number;
    }


    public static int numberOfDigits(int number) {
        var length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }


    @Test
    void exampleTests() {
        assertTrue(ArmstrongNumber.isNarcissistic(153), "153 is narcissistic");
        assertTrue(ArmstrongNumber.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(ArmstrongNumber.isNarcissistic(112), "112 is not narcissistic");
    }

}
