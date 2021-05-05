import java.util.Arrays;

public class NextBiggerNumber {

    public static void main(String[] args) {

        System.out.println(nextBiggerNumber(12)); // 21
        System.out.println(nextBiggerNumber(513)); // 531
        System.out.println(nextBiggerNumber(2017)); // 2071
        System.out.println(nextBiggerNumber(414)); // 441
        System.out.println(nextBiggerNumber(144)); // 414
        System.out.println(nextBiggerNumber(10990)); // 19009
        System.out.println(nextBiggerNumber(111)); // -1
        System.out.println(nextBiggerNumber(531)); // -1
        System.out.println(nextBiggerNumber(9)); // -1
        System.out.println(nextBiggerNumber(2147536890L)); // -1
        System.out.println(nextBiggerNumber(4104233499L)); // -1
    }

    public static long nextBiggerNumber(long n) {
        if (n < 10) return -1;
        Long rezult = -1L;

        String s = Long.toString(n);
        long[] longArrN = new long[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            longArrN[i] = n % 10;
            n /= 10;
        }
       System.out.println(" + " + Arrays.toString(longArrN));

        long count = fuctorial(longArrN.length);
        int max = longArrN.length - 1;
        int shift = max;
        while (count > 0) {
            long t = longArrN[shift];
            longArrN[shift] = longArrN[shift - 1];
            longArrN[shift - 1] = t;
          //  System.out.println(" ++ " + Arrays.toString(longArrN));
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
/*        for (int i = 0; i < longArrN.length; i++) {
            try {
                if (longArrN[i] == n) return longArrN[i+1];
            } catch (Exception e) {
                return -2;
            }
        }*/

        rezult = longArrN[longArrN.length-1];

        return rezult;
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }
}