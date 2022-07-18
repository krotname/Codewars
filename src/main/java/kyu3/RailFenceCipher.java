package kyu3;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RailFenceCipher {

    //3 https://www.codewars.com/kata/58c5577d61aefcf3ff000081/train/java

    static String encode(String s, int n) {
        Map<Integer, StringBuilder> map = new TreeMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            map.put(i, new StringBuilder());
        }
        char[] chars = s.toCharArray();
        Counter counter = new Counter(n - 1);

        for (int i = 0; i < s.length(); i++) {
            int tik = counter.tik();
            StringBuilder stringBuilder = map.get(tik);
            stringBuilder.append(chars[i]);
            map.put(tik, stringBuilder);
        }

        for (Map.Entry<Integer, StringBuilder> e : map.entrySet()
        ) {
            result.append(e.getValue());
        }

        return result.toString();
    }

    static String decode(String s, int n) {
        int[] size = new int[n];
        Counter counter = new Counter(n - 1);
        for (int i = 0; i < s.length(); i++) {
            int tik = counter.tik();
            size[tik]++;
        }
        Map<Integer, StringBuilder> map = new TreeMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                stringBuilder.append(s, 0, size[0]);
            } else {
                int start = sumArr(size, i);
                int end = start + size[i];
                stringBuilder.append(s, start, end);
            }
            map.put(i, stringBuilder);
        }

        Map<Integer, LinkedList<String>> map2 = new TreeMap<>();

        for (Map.Entry<Integer, StringBuilder> e : map.entrySet()
        ) {
            LinkedList<String> strings = new LinkedList<>();
            for (char c : e.getValue().toString().toCharArray()) {
                strings.add(String.valueOf(c));
            }
            map2.put(e.getKey(), strings);
        }

        Counter counterRes = new Counter(n - 1);
        for (int i = 0; i < s.length(); i++) {
            int tik = counterRes.tik();
            result.append(map2.get(tik).poll());
        }

        return result.toString();
    }

    private static int sumArr(int[] arr, int i) {
        int result = 0;
        for (int j = 0; j < i; j++) {
            result += arr[j];
        }
        return result;
    }

    /**
     * Create two functions to encode and then decode a string using the Rail Fence Cipher. This cipher is used to encode
     * a string by placing each character successively in a diagonal along a set of "rails". First start off moving diagonally
     * and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail.
     * Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.
     * <p>
     * For example, the string "WEAREDISCOVEREDFLEEATONCE" could be represented in a three rail system as follows:
     * <p>
     * W       E       C       R       L       T       E
     * E   R   D   S   O   E   E   F   E   A   O   C
     * A       I       V       D       E       N
     * The encoded string would be:
     * <p>
     * WECRLTEERDSOEEFEAOCAIVDEN
     * Write a function/method that takes 2 arguments, a string and the number of rails, and returns the ENCODED string.
     * <p>
     * Write a second function/method that takes 2 arguments, an encoded string and the number of rails, and returns the
     * DECODED string.
     * <p>
     * For both encoding and decoding, assume number of rails >= 2 and that passing an empty string will return an empty string.
     * <p>
     * Note that the example above excludes the punctuation and spaces just for simplicity. There are, however, tests
     * that include punctuation. Don't filter out punctuation as they are a part of the string.
     */


    @Test
    public void testEncode() {
        assertEquals("Hoo!el,Wrdl l", encode("Hello, World!", 3));
        assertEquals("159246837", encode("123456789", 3));
        assertEquals("135792468", encode("123456789", 2));
        assertEquals("WLREAINERTEDOEEOAVECESFCD", encode("WECRLTEERDSOEEFEAOCAIVDEN", 3));
    }

    @Test
    public void testDecode() {
        assertEquals("Hello, World!", decode("Hoo!el,Wrdl l", 3));
        assertEquals("123456789", decode("159246837", 3));
    }

    private static class Counter {
        // класс возвращает от нуля до заданного максимального значения на каждом тике,
        // а после достижение максимального значения разворачивается на убывание и так по кругу
        private final int max;
        private boolean vector = true;
        private boolean start = true;
        private int count = 0;

        private Counter(int max) {
            this.max = max;
        }

        private int tik() {
            if (start) {
                start = false;
                return 0;
            }
            if (vector) {
                if (count < max) {
                    count++;
                    return count;
                }
                if (count == max) {
                    vector = false;
                    count--;
                    return count;
                }
            }
            if (!vector) {
                if (count > 0) {
                    count--;
                    return count;
                }
                if (count == 0) {
                    vector = true;
                    count++;
                    return count;
                }
            }
            return count;
        }
    }
}
