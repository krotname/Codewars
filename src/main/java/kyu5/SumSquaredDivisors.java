package kyu5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumSquaredDivisors {
    //5 https://www.codewars.com/kata/55aa075506463dac6600010d/train/java
    /*1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246. Squaring these divisors we get: 1, 60516, 4, 15129, 9, 6724, 36, 1681. The sum of these squares is 84100 which is 290 * 290.

Task
Find all integers between m and n (m and n integers with 1 <= m <= n) such that the sum of their squared divisors is itself a square.

We will return an array of subarrays or of tuples (in C an array of Pair) or a string. The subarrays (or tuples or Pairs) will have two elements: first the number the squared divisors of which is a square and then the sum of the squared divisors.

Example:
list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]
The form of the examples may change according to the language, see "Sample Tests".

Note
In Fortran - as in any other language - the returned string is not permitted to contain any redundant trailing whitespace: you can use dynamically allocated character strings.*/

    public static void main(String[] args) {
        System.out.println(listSquared(1, 250)); // [[1, 1], [42, 2500], [246, 84100]]
    }

    public static String listSquared(long m, long n) {
        Map<Long, Long> result = new HashMap<>();
        for (long i = m; i < n; i++) {
            long sumSquare = sumSquareList(listDivisor(i));
            if (checkSquare(sumSquare)) {
                result.putIfAbsent(i, sumSquare);
                //System.out.println(i  +  "  - "+ sumSquare);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Map.Entry<Long, Long> entry : result.entrySet()
        ) {
            //todo обыграть запятую
            stringBuilder.append("[").append(entry.getKey()).append(",").append(entry.getValue()).append("],");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public static boolean checkSquare(long n) {
        return Math.sqrt(n) % 1 == 0.0;
    }

    public static List<Long> listDivisor(long n) {
        List<Long> l = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                l.add(i);
            }
        }
        return l;
    }

    public static long sumSquareList(List<Long> list) {
        long result = 0;
        for (long i : list) {
            result += i * i;
        }
        return result;
    }
}
