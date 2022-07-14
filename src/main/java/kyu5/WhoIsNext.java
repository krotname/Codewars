package kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhoIsNext {

    //6 https://www.codewars.com/kata/551dd1f424b7a4cdae0001f0/train/java

    private static final String[] testNames = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};

    @Test
    public void test() {
        assertEquals("Sheldon", WhoIsNext(testNames, 1));
        assertEquals("Sheldon", WhoIsNext(testNames, 6));
        assertEquals("Howard", WhoIsNext(testNames, 15));
        assertEquals("Sheldon", WhoIsNext(testNames, Integer.MAX_VALUE / 100));
    }

    @Test
    public void testLinkedList() {
        assertEquals("Sheldon", WhoIsNextLinkedList(testNames, 1));
        assertEquals("Sheldon", WhoIsNextLinkedList(testNames, 6));
        assertEquals("Howard", WhoIsNextLinkedList(testNames, 15));
        // to slow assertEquals("Sheldon", WhoIsNextLinkedList(testNames, Integer.MAX_VALUE / 100));
    }

    public static String WhoIsNext(String[] names, int n) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(names));
        for (int i = 0; i < n; i++) {
            strings.add(strings.get(i));
            strings.add(strings.get(i));
        }
        return strings.get(n - 1);
    }

    public static String WhoIsNextLinkedList(String[] names, int n) {
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
