package kyu7;

import java.util.ArrayList;
import java.util.Comparator;

public class DescendingOrder {
    //7 https://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java

    public static void main(String[] args) {
        System.out.println(sortDesc(0));
        System.out.println(sortDesc(1));
        System.out.println(sortDesc(42145)); //54421
        System.out.println(sortDesc(123456789)); //987654321
    }

    public static int sortDesc(int num) {
        if (num <= 0) return 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (num != 0) {
            int i = num % 10;
            num /= 10;
            arrayList.add(i);
        }
        arrayList.sort(Comparator.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : arrayList
        ) {
            stringBuilder.append(i);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
