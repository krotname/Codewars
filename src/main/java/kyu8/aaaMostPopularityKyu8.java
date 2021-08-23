package kyu8;

public class aaaMostPopularityKyu8 {
    public static void main(String[] args) {
    }

    public static String boolToWord(boolean b)
    {
        return b ? "Yes" : "No";
    }
    public static String reversedStrings(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int summation(int n) {
        if (n <= 0){
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


}
