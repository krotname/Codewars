package kyu8;

import java.util.ArrayList;
import java.util.Arrays;

public class AllMostPopularityKyu8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digitize(35231)));
        System.out.println(past(0, 1, 1));
        System.out.println(Liters(0.4));
        System.out.println(abbrevName("patrick fen"));
        System.out.println(getAverage(new int[]{1, 2, 3}));
        System.out.println(reverseWords("I like eating"));
        System.out.println(fakeBin("45385593107843568"));
        System.out.println(Arrays.toString(countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15})));
        System.out.println(sum(new int[]{6, 2, 1, 8, 10}));
        System.out.println(sum(new int[]{-1, -50, -100}));
    }

    public static int sum(int[] numbers) {
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
        boolean maxB = true, minB = true;
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

    public static int[] map(int[] arr) {
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


    public static String findNeedle(Object[] haystack) {
        if (haystack == null || haystack.length == 0) return "not found";
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] != null && haystack[i].equals("needle")) {
                return "found the needle at position " + i;
            }
        }
        return "not found";
    }


    public static String abbrevName(String name) {
        String[] s = name.split(" ");
        return s[0].substring(0, 1).toUpperCase() + "." + s[1].substring(0, 1).toUpperCase();
    }

    public static int past(int h, int m, int s) {
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
        return x.replaceAll(" ", "");
    }

    public static String numberToString(int num) {
        return String.valueOf(num);
    }

    public static int findSmallestInt(int[] args) {
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

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        if (arrayOfSheeps == null || arrayOfSheeps.length == 0) return 0;
        int count = 0;
        for (Boolean b : arrayOfSheeps
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
        return (number - 1) / 100 + 1;
    }

    public static int Liters(double time) {

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

        return 0;
    }


}
