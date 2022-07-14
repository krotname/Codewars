package other;

// Выводит результат умножения цифр положительного числа в цикле, пока не останется однозначное число

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Persist {

    @Test
    public void test() {
        assertEquals(3, persistence(39));
        assertEquals(4, persistence(999)); // because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2
        assertEquals(0, persistence(4));
    }

    public int persistence(long n) {
        int result = 0;
        while (n > 9) {
            char[] s = String.valueOf(n).toCharArray();
            int temp = Integer.parseInt(String.valueOf(s[0]));
            for (int i = 1; i < s.length; i++) {
                temp *= Integer.parseInt(String.valueOf(s[i]));
            }
            n = temp;
            result++;
        }
        return result;
    }
}
