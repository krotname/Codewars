package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HighAndLow {
    //7 https://www.codewars.com/kata/554b4ac871d6813a03000035/train/java

    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4")); // "42 -9"
        System.out.println(highAndLow2("8 3 -5 42 -1 0 0 -9 4 7 4 -4")); // "42 -9"
    }

    public static String highAndLow(String numbers) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (String s : numbers.split("\\s")) {
            integers.add(Integer.valueOf(s));
        }
        Collections.sort(integers);
        return integers.get(integers.size() - 1) + " " + integers.get(0);
    }

    public static Integer highAndLow2(String numbers) {
        String[] split = numbers.split("\\s");
        return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList()).stream().max(Comparator.naturalOrder()).get();
    }

}
