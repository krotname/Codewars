package kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescendingOrder {

    //7 https://www.codewars.com/kata/5467e4d82edf8bbf40000155/train/java

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

    @Test
    public void test() {
        assertEquals(0, sortDesc(0));
        assertEquals(1, (sortDesc(1)));
        assertEquals(54421, (sortDesc(42145)));
        assertEquals(987654321, (sortDesc(123456789)));
    }
}
