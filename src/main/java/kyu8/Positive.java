package kyu8;

public class Positive {

    //8

    /**
     * You get an array of numbers, return the sum of all of the positives ones.
     * <p>
     * Example [1,-4,7,12] => 1 + 7 + 12 = 20
     * <p>
     * Note: if there is nothing to sum, the sum is default to 0.
     */

    public static void main(String[] args) {
        System.out.println((sum(new int[]{1, 2, 3, 4, 5}))); //15
        System.out.println((sum(new int[]{1, -2, 3, 4, 5}))); //13
        System.out.println((sum(new int[]{}))); //0
        System.out.println((sum(new int[]{-1, -2, -3, -4, -5}))); //0
        System.out.println((sum(new int[]{-1, 2, 3, 4, -5})));//9
    }

    public static int sum(int[] arr) {
        int rezult = 0;
        if (arr == null || arr.length == 0) return rezult;
        for (int num : arr
        ) {
            if (num > 0) rezult += num;
        }
        return rezult;
    }
}
