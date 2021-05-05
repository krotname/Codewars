import java.util.ArrayList;
import java.util.List;

public class HowManyNumbers {
    public static void main(String[] args) {
        System.out.println(findAll(10, 3)); //8L, 118L, 334L
        System.out.println(findAll(27, 3)); //1L, 999L, 999L
        System.out.println(findAll(84, 4));
        System.out.println(findAll(35, 6)); //123L, 116999L, 566666L
        System.out.println(findAll(34, 8)); //440, 11113999, 44444455
        System.out.println(findAll(25, 10)); //164, 11111299, 33333334

    }

    public static List<Long> findAll(final int sumDigits, final int numDigits) {

        long firstValue = 0L;
        long lastValue = 0L;
        long countValue = 0L;
        long start = (long) (Math.pow(10, numDigits - 1));
        long finish = start * 10;
        for (long i = start; i < finish; i++) {
            if (sumDigits(i) == sumDigits && digitsIncreasingOrder(i)) {
                countValue++;
                lastValue = i;
                if (firstValue == 0L) firstValue = i;
            }
        }

        List<Long> result = new ArrayList<>();
        if (countValue > 0L) {
            result.add(countValue);
            result.add(firstValue);
            result.add(lastValue);
        }
        return result;
    }

    public static long sumDigits(long n) {
        long result = 0;
        while (n > 0) {
            result = result + n % 10;
            n /= 10;
        }
        return result;
    }

    public static boolean digitsIncreasingOrder(long n) {
        long temp = n % 10;
        n /= 10;
        while (n > 0) {
            if (n % 10 > temp) return false;
            temp = n % 10;
            n /= 10;
        }
        return true;
    }

}
