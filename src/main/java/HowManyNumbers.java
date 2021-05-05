package codewars;

import java.util.ArrayList;
import java.util.List;

public class HowManyNumbers {
    public static void main(String[] args) {
        System.out.println(findAll(10, 3)); //8L, 118L, 334L
        System.out.println(findAll(27, 3)); //1L, 999L, 999L
        System.out.println(findAll(84, 4));
        System.out.println(findAll(35, 6)); //123L, 116999L, 566666L

    }
    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        List<Long> result = new ArrayList<>();
        List<Long> arr = new ArrayList<>();
        long start = (int) (Math.pow(10,numDigits-1));
        long finish = start * 10 -1;
        for (long i = start; i < finish ; i++) {
            if (sumDigits(i) == sumDigits && digitsIncreasingOrder(i)){
                arr.add(i);
            }
        }
        System.out.println(arr);
        if (arr.size()>0){
            result.add((long) arr.size());
            result.add(arr.get(0));
            result.add(arr.get(arr.size()-1));
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
    public static boolean  digitsIncreasingOrder (long n) {
        // todo revers сделать не по убыванию а по возрастанию
        boolean result = true;
        long temp = 0;
        while (n > 0) {
            if (n % 10 < temp) result = false;
            temp = n % 10;
            n /= 10;
        }
        return result;
    }

}
