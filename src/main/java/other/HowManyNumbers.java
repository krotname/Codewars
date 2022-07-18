package other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Просчитывает варианты numDigits`значных чисел в которых сумма чисел равна sumDigits и цифры идут по порядку
// и выводит массив количество найденых цифр, первое и последние

public class HowManyNumbers {

    private static long sumDigits(long n) {
        long result = 0;
        while (n > 0) {
            result = result + n % 10;
            n /= 10;
        }
        return result;
    }

    private static boolean digitsIncreasingOrder(long n) {
        long temp = n % 10;
        n /= 10;
        while (n > 0) {
            if (n % 10 > temp) return false;
            temp = n % 10;
            n /= 10;
        }
        return true;
    }

    public List<Long> findAll(final int sumDigits, final int numDigits) {
        long firstValue = 0L;
        long lastValue = 0L;
        long countValue = 0L;
        long start = (long) (Math.pow(10, numDigits - 1.0));
        long finish = start * 10;
        for (long i = start; i < finish; i++) {
            if (digitsIncreasingOrder(i) && sumDigits(i) == sumDigits) {
                countValue++;
                lastValue = i;
                if (firstValue == 0L) firstValue = i;
            }
        }

        List<Long> result = new ArrayList<>(3);
        if (countValue > 0L) {
            result.add(countValue);
            result.add(firstValue);
            result.add(lastValue);
        }
        return result;
    }

    @Test
    public void testHowManyNumbers() {
        assertEquals(List.of(8L, 118L, 334L), findAll(10, 3));
        assertEquals(List.of(1L, 999L, 999L), findAll(27, 3));
        assertEquals(List.of(), findAll(84, 4));
        assertEquals(List.of(123L, 116999L, 566666L), findAll(35, 6));
        assertEquals(List.of(440L, 11113999L, 44444455L), findAll(34, 8));
        // assertEquals(List.of(134L, 1111111189L, 2222233333L), findAll(25, 10)); // долгий тест
    }

}
