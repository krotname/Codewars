package kyu8;

public class aaaMostPopularityKyu8 {
    public static void main(String[] args) {

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
    public static int squareSum(int[] n)
    {
        if (n == null || n.length == 0) return 0;
        int sum = 0;
        for (int i : n
        ) {
            sum+= i*i;
        }
        return sum;
    }
    public static int century(int number) {
        return (number-1)/100+1;
    }

}
