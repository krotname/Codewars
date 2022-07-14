package kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Prime {

    //6 https://www.codewars.com/kata/5262119038c0985a5b00029f/train/java

    public static boolean isPrime(int num) {
        return num > 0 && BigInteger.valueOf(num).isProbablePrime((int) Math.log(num) + 1);
    }

    @Test
    public void testBasic() {
        assertFalse(isPrime(0));
        assertFalse(isPrime(1));
        assertTrue(isPrime(2));
        assertTrue(isPrime(73));
        assertFalse(isPrime(75));
        assertFalse(isPrime(-1));
    }

    @Test
    public void testPrime() {
        assertTrue(isPrime(3));
        assertTrue(isPrime(5));
        assertTrue(isPrime(7));
        assertTrue(isPrime(41));
        assertTrue(isPrime(5099));
    }

    @Test
    public void testNotPrime() {
        assertFalse(isPrime(4));
        assertFalse(isPrime(6));
        assertFalse(isPrime(8));
        assertFalse(isPrime(9));
        assertFalse(isPrime(45));
        assertFalse(isPrime(-5));
        assertFalse(isPrime(-8));
        assertFalse(isPrime(-41));
    }

}
