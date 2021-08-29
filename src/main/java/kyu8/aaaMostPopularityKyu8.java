package kyu8;

public class aaaMostPopularityKyu8 {
    public static void main(String[] args) {
        System.out.println(Liters(0.4));
        System.out.println(Liters(0.5));
        System.out.println(Liters(0.6));
        System.out.println(Liters(2));
        System.out.println(Liters(0.97));
        System.out.println(Liters(14.64));
        System.out.println(Liters(80));
        System.out.println(Liters(1600.20));
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
    public static int Liters(double time)  {

        return (int) ( time/2);
    }
    public static boolean isDivisible(long n, long x, long y) {
        if (n <=0 ||x <=0 ||y <=0 ) {
            return false;
        }
        if (n %x == 0 && n %y == 0 ){
            return true;
        }
        return false;
    }
    public static Integer basicMath(String op, int v1, int v2)
    {
        if (op.equals("+")) {
            return v1+v2;
        }else if (op.equals("-")){
            return v1-v2;
        }else if (op.equals("*")){
            return v1*v2;
        }else if (op.equals("/") && v2 != 0){
            return v1/v2;
        }

        return 0;
    }


}
