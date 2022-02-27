package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TenMinWalk {

    //6 https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java

    public static boolean isValid(char[] walk) {
        int ns = 0;
        int ew = 0;
        int t = 0;
        for (char c : walk) {
            if (c == 'n') ns++;
            if (c == 's') ns--;
            if (c == 'e') ew++;
            if (c == 'w') ew--;
            t++;
        }
        return ns == 0 && ew == 0 && t ==10;
    }

    @Test
    public void Test() {
        assertEquals(true, TenMinWalk.isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        assertEquals(false, TenMinWalk.isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        assertEquals(false, TenMinWalk.isValid(new char[]{'w'}));
        assertEquals(false, TenMinWalk.isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
    }
}
