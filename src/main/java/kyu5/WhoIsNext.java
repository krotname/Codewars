package kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class WhoIsNext {
    //6 https://www.codewars.com/kata/551dd1f424b7a4cdae0001f0/train/java
    // не работает, таймаут
    public static void main(String[] args) {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        System.out.println(WhoIsNext(names, 1)); // Sheldon
        System.out.println(WhoIsNext(names, 6)); // Sheldon
        System.out.println(WhoIsNext(names, 15)); //
        System.out.println(WhoIsNext(names, Integer.MAX_VALUE / 100)); //
    }

    public static String WhoIsNext(String[] names, int n) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(names));
        for (int i = 0; i < n; i++) {
                strings.add(strings.get(i));
                strings.add(strings.get(i));
        }
        return strings.get(n-1);
    }

    public static String WhoIsNextOld(String[] names, int n)
    {
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(names));

        for (int i = 1; i < n; i++) {
            String poll = strings.poll();
            if (strings.size() <= n) {
                strings.add(poll);
                strings.add(poll);
            }
        }
        return strings.peek();
    }

}
