package codewars;

import java.util.stream.IntStream;

public class findEvenIndex {
    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[] {1,2,3,4,3,2,1})); // 3
        System.out.println(findEvenIndex(new int[] {1,100,50,-51,1,1})); //1
        System.out.println(findEvenIndex(new int[] {1,2,3,4,5,6})); // -1
        System.out.println(findEvenIndex(new int[] {20,10,30,10,10,15,35})); //3
        System.out.println(findEvenIndex(new int[] {-8505, -5130, 1926, -9026})); // -1
        System.out.println(findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094})); // 1
        System.out.println(findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4})); //6
    }

    public static int findEvenIndex(int[] arr) {

        int sumArr = IntStream.of(arr).sum();
        int firstHalfSumm = 0;
        int secondHalfSumm = 0;
        int halfIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            firstHalfSumm += arr[i];
            if (firstHalfSumm >= (sumArr/2)) {
                halfIndex = i;
                firstHalfSumm -= arr[i];
                break;
            }
        }
        for (int i = arr.length-1; i > halfIndex; i--) {
            secondHalfSumm += arr[i];
        }
        if (firstHalfSumm == secondHalfSumm) return halfIndex;
        return -1;
    }
}