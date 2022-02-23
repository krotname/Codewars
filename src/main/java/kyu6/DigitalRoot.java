package kyu6;

public class DigitalRoot {
    //6

    /**
     * Digital root is the recursive sum of all the digits in a number.
     * Given n, take the sum of the digits of n. If that value has more than one
     * digit, continue reducing in this way until a single-digit number is produced.
     * The input will be a non-negative integer.
     */

    public static void main(String[] args) {

        System.out.println(digital_root(16));
        System.out.println(digital_root(456));
        System.out.println(digital_root(493193));

    }

    public static int digital_root(int n) {
        if (n < 10) return n;
        int temp = n;
        int result;
        do {
            result = 0;
            while (temp > 0) {
                result = result + temp % 10;
                temp /= 10;
            }
            temp = result;
        } while (result > 9);
        return result;
    }

}
