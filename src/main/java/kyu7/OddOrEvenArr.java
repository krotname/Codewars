package kyu7;

import java.util.Arrays;

public class OddOrEvenArr {
    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[] {2, 5, 34, 6}));
        System.out.println(oddOrEven(new int[] {2, 5, 34, 7}));
    }
    public static String oddOrEven (int[] array) {
        return Arrays.stream(array).sum()%2!=0? "odd":"even";
    }
}
