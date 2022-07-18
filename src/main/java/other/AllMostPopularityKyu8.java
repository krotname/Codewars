package other;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AllMostPopularityKyu8 {

    public static int sumR(int[] arr) {
        int rezult = 0;
        if (arr == null || arr.length == 0) return rezult;
        for (int num : arr
        ) {
            if (num > 0) rezult += num;
        }
        return rezult;
    }

    public static String repeatStr(final int repeat, final String string) {
        return String.valueOf(string).repeat(Math.max(0, repeat));
    }

    public static String removeFirstAndLastChar(String str) {
        return str.substring(1, str.length() - 1);

    }

    public static int opposite(int number) {
        return number * -1;
    }

    public static String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    public static int sumArray(int[] numbers) {
        //сумма кроме самого большого и маленького
        if (numbers == null || numbers.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : numbers
        ) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        boolean maxB = true;
        boolean minB = true;
        for (int n : numbers
        ) {
            if (maxB && n == max) {
                maxB = false;
            } else if (minB && n == min) {
                minB = false;
            } else {
                sum += n;
            }
        }
        return sum;
    }

    public static String fakeBin(String numberString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : numberString.toCharArray()) {
            if (Character.getNumericValue(c) >= 5) {
                stringBuilder.append("1");
            } else if (Character.getNumericValue(c) < 5) {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    public static int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public static String reverseWords(String str) {
        String[] s = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            stringBuilder.append(s[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static int[] allTo2(int[] arr) {
        return Arrays.stream(arr).map(x -> x * 2).toArray();
    }

    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(x -> x * -1).toArray();
    }

    public static int getAverage(int[] marks) {
        return (int) Arrays.stream(marks).average().orElse(0);
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) return new int[0];
        int countPositive = 0;
        int summNegative = 0;
        for (int i : input
        ) {
            if (i > 0) {
                countPositive++;
            } else {
                summNegative -= i;
            }
        }
        int[] result = new int[2];
        result[0] = countPositive;
        result[1] = summNegative * -1;
        return result; //return an array with count of positives and sum of negatives
    }

    public static String abbrevName(String name) {
        String[] s = name.split(" ");
        return s[0].substring(0, 1).toUpperCase() + "." + s[1].substring(0, 1).toUpperCase();
    }

    public static int timeInSeconds(int h, int m, int s) {
        return s * 1000 + m * 60 * 1000 + h * 60 * 60 * 1000;
    }

    public static int[] digitize(long n) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (n > 0) {
            int l = (int) (n % 10);
            integers.add(l);
            n = n / 10;
        }

        int[] r = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            r[i] = integers.get(i);
        }

        return r;
    }

    public static String boolToWord(boolean b) {
        return b ? "Yes" : "No";
    }

    public static String reversedStrings(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int summation(int n) {
        if (n <= 0) {
            return 0;
        }
        int x = n;
        for (int i = 1; i < x; i++) {
            n += i;
        }
        return n;
    }

    public static String noSpace(final String x) {
        return x.replaceAll("\\s", "");
    }

    public static String numberToString(Number num) {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(num);
    }

    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args).sorted().findFirst().orElseThrow();
    }

    public static int findSmallestIntBadO(int[] args) {
        if (args == null || args.length == 0) return 0;
        if (args.length == 1) return args[0];
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    public static int countSheep(Boolean[] arrayOfSheep) {
        if (arrayOfSheep == null || arrayOfSheep.length == 0) return 0;
        int count = 0;
        for (Boolean b : arrayOfSheep
        ) {
            if (b != null && b) {
                count++;
            }
        }
        return count;
    }

    public static int squareSum(int[] n) {
        if (n == null || n.length == 0) return 0;
        int sum = 0;
        for (int i : n
        ) {
            sum += i * i;
        }
        return sum;
    }

    public static int century(int number) {
        return (number) / 100 + 1;
    }

    public static int liters(double time) {
        return (int) (time / 2);
    }

    public static boolean isDivisible(long n, long x, long y) {
        if (n <= 0 || x <= 0 || y <= 0) {
            return false;
        }
        return n % x == 0 && n % y == 0;
    }

    public static Integer basicMath(String op, int v1, int v2) {
        if (op.equals("+")) {
            return v1 + v2;
        } else if (op.equals("-")) {
            return v1 - v2;
        } else if (op.equals("*")) {
            return v1 * v2;
        } else if (op.equals("/") && v2 != 0) {
            return v1 / v2;
        }
        throw new IllegalArgumentException();
    }

    @Test
    public void testAllMostPopularityKyu8() {
        assertEquals("[1, 3, 2, 5, 3]", Arrays.toString(digitize(35231)));

        assertEquals(61000, timeInSeconds(0, 1, 1));

        assertEquals(0, liters(0.4));

        assertEquals("P.F", abbrevName("patrick fen"));

        assertEquals(2, getAverage(new int[]{1, 2, 3}));

        assertEquals("eating like I", reverseWords("I like eating"));

        assertEquals("01011110001100111", fakeBin("45385593107843568"));

        assertEquals("[10, -65]",
                Arrays.toString(
                        countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15})));

        assertEquals(16, sumArray(new int[]{6, 2, 1, 8, 10}));
        assertEquals(-50, sumArray(new int[]{-1, -50, -100}));

        assertEquals("Even", evenOrOdd(6));
        assertEquals("Odd", evenOrOdd(7));

        assertEquals(-1, opposite(1));
        assertEquals(2, opposite(-2));
        assertEquals(-2147483647, opposite(Integer.MAX_VALUE));

        assertEquals(15, sumR(new int[]{1, 2, 3, 4, 5}));
        assertEquals(13, sumR(new int[]{1, -2, 3, 4, 5}));
        assertEquals(0, sumR(new int[]{}));
        assertEquals(0, sumR(new int[]{-1, -2, -3, -4, -5}));
        assertEquals(9, sumR(new int[]{-1, 2, 3, 4, -5}));

        assertEquals("IIIIII", repeatStr(6, "I"));
        assertEquals("HelloHelloHelloHelloHello", repeatStr(5, "Hello"));

        assertEquals("ountr", removeFirstAndLastChar("country"));

        assertEquals("Yes", boolToWord(true));
        assertEquals("No", boolToWord(false));

        assertEquals("No", reversedStrings("oN"));

        assertEquals(15, summation(5));

        assertEquals("iampatrickfen", noSpace("i am patrick fen"));

        assertEquals("5", numberToString(5L));
        assertEquals("5", numberToString(5.0));

        assertEquals(1, findSmallestInt(new int[]{5, 1, 9}));

        assertEquals(1, findSmallestIntBadO(new int[]{5, 1, 9}));

        assertEquals(1, countSheep(new Boolean[]{false, true, false}));

        assertEquals(107, squareSum(new int[]{5, 1, 9}));

        assertEquals(68, stringToNumber("68"));

        assertEquals(20, century(1995));
        assertEquals(20, century(1999));
        assertEquals(21, century(2000));


        assertEquals(4, basicMath("+", 2, 2));
        assertEquals(4, basicMath("*", 2, 2));
        assertEquals(0, basicMath("-", 2, 2));
        assertEquals(1, basicMath("/", 2, 2));


        assertTrue(isDivisible(10, 5, 2));
        assertFalse(isDivisible(10, 5, 3));

        assertArrayEquals(new int[]{3, -2,}, invert(new int[]{-3, 2,}));
        assertArrayEquals(new int[]{-6, 4,}, allTo2(new int[]{-3, 2,}));

        assertEquals(68, stringToNumber("68"));
        assertEquals(68, stringToNumber("68"));
        assertEquals(68, stringToNumber("68"));
    }
}
