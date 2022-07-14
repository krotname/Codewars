package leetcode;

import org.junit.jupiter.api.Test;

public class ReverseInt {

    @Test
    public void test() {
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(123));
        System.out.println(reverseInt.reverse(-123));
        System.out.println(reverseInt.reverse(120));
        System.out.println(reverseInt.reverse(0));
    }

    public int reverse(int x) {
        if (x >= 0) {
            return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
        } else {
            return Integer.parseInt(new StringBuilder(String.valueOf(x).substring(1)).reverse().toString()) * -1;
        }
    }

}
