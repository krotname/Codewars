package codewars;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static void main(String[] args) {
        System.out.println(5 + " " + FindOdd.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        System.out.println(-1 + " " + FindOdd.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        System.out.println(5 + " " + FindOdd.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        System.out.println(10 + " " + FindOdd.findIt(new int[]{10}));
        System.out.println(10 + " " + FindOdd.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        System.out.println(1 + " " + FindOdd.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }

    public static int findIt(int[] a) {
        /*Given an array of integers, find the one that appears an odd number of times.

                There will always be only one integer that appears an odd number of times.*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a
        ) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);

            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()
        ) {
            if (e.getValue() % 2 != 0) return e.getKey();
        }
        return 0;
    }

}
