import java.math.BigInteger;

public class BlockSequence {
    /*Consider the following array:

[1, 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789, 12345678910, 1234567891011...]
If we join these blocks of numbers, we come up with an infinite sequence which starts with 112123123412345123456.... The list is infinite.

You will be given an number (n) and your task will be to return the element at that index in the sequence, where 1 ≤ n ≤ 10^18. Assume the indexes start with 1, not 0. For example:

solve(1) = 1, because the first character in the sequence is 1. There is no index 0.
solve(2) = 1, because the second character is also 1.
solve(3) = 2, because the third character is 2.
More examples in the test cases. */

    public static void main(String[] args) {

        System.out.println(solve(1));
        System.out.println(solve(3));
        System.out.println(solve(5));
        System.out.println(solve(10));
        System.out.println(solve(14));
    }
    public static int solve(long n){
        BigInteger big = new BigInteger("1");
        BigInteger append = new BigInteger("1");
        while (!check(big, n)){
            big = new BigInteger(big.toString() + append.toString());
            char c = append.toString().toCharArray()[append.toString().length()-1];
            int i = Integer.parseInt(String.valueOf(c))+1;
            append = new BigInteger(append.toString() + i);
        }
        System.out.println(big);
        return big.toString().length()-String.valueOf(n).length()+1;
    }
    public static boolean check (BigInteger b, long n){
        char[] charN = String.valueOf(n).toCharArray();
        char[] charB =  b.toString().toCharArray();
        for (int i = 1; i <= charN.length; i++) {
            try {
                if (charN[charN.length-i] != charB[charB.length-i]) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

}
