package kyu6;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDiff {
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
