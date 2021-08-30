package kyu6;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDiff {
    //6 https://www.codewars.com/kata/523f5d21c841566fde000009
    /*Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}*/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayDiff(new int [] {1,2,3,4,4,5,6,7,7,7}, new int[] {7,1})));
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2}, new int[]{1})));
        System.out.println(Arrays.toString(arrayDiff(new int [] {1,2,2}, new int[] {1})));
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i :a
             ) {
                boolean ex = false;
            for (int j:b
                 ) {
                if (i == j){
                    ex = true;
                }
            }
            if (!ex) {
                integers.add(i);
            }
        }

        return integers.stream().mapToInt(i -> i).toArray();
    }
}
