package kyu3;

import java.util.HashMap;
import java.util.Map;

public class RailFenceCipher {


    //3 https://www.codewars.com/kata/58c5577d61aefcf3ff000081/train/java
    /*Create two functions to encode and then decode a string using the Rail Fence Cipher. This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails". First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail. Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.

For example, the string "WEAREDISCOVEREDFLEEATONCE" could be represented in a three rail system as follows:

W       E       C       R       L       T       E
  E   R   D   S   O   E   E   F   E   A   O   C
    A       I       V       D       E       N
The encoded string would be:

WECRLTEERDSOEEFEAOCAIVDEN
Write a function/method that takes 2 arguments, a string and the number of rails, and returns the ENCODED string.

Write a second function/method that takes 2 arguments, an encoded string and the number of rails, and returns the DECODED string.

For both encoding and decoding, assume number of rails >= 2 and that passing an empty string will return an empty string.

Note that the example above excludes the punctuation and spaces just for simplicity. There are, however, tests that include punctuation. Don't filter out punctuation as they are a part of the string.*/


    public static void main(String[] args) {
        System.out.println(encode("Hello, World!", 3));
        System.out.println(encode("123456789", 3));
        System.out.println(encode("WECRLTEERDSOEEFEAOCAIVDEN", 3));
        System.out.println(decode("Hoo!el,Wrdl l", 3));
    }

    static String encode(String s, int n) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            map.put(i, new StringBuilder());
        }
        char[] chars = s.toCharArray();
        Counter counter = new Counter(n-1);

        int i1 = s.length() / n;

        for (int i = 0; i < s.length(); i++) {
            int tik = counter.tik();
            StringBuilder stringBuilder = map.get(tik);
            stringBuilder.append(chars[i]);
            map.put(tik, stringBuilder);
        }

        for (Map.Entry<Integer, StringBuilder> e : map.entrySet()
        ) {
            //System.out.println(e.getValue());
            result.append(e.getValue());
        }

        return result.toString();
    }

    static String decode(String s, int n) {
        //todo decode split 
        return "";
    }

    private static class Counter {
        // класс возвращает от нуля до заданного максимального значения на каждом тике,
        // а после достижение максимального значения разворачивается на убывание и так по кругу
        private int max;
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
