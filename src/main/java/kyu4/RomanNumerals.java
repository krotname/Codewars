package kyu4;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
    //4
    //https://www.codewars.com/kata/51b66044bce5799a7f000003/train/java
    /*Create a RomanNumerals class that can convert a roman numeral to and from an integer value. It should follow the API demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").*/

    private static final Map<Integer, Character> MAP_TO = new LinkedHashMap<>();
    private static final Map<Character, Integer> MAP_FROM = new LinkedHashMap<>();

    static {
        MAP_TO.put(1000, 'M');
        MAP_TO.put(500, 'D');
        MAP_TO.put(100, 'C');
        MAP_TO.put(50, 'L');
        MAP_TO.put(10, 'X');
        MAP_TO.put(5, 'V');
        MAP_TO.put(1, 'I');

        MAP_FROM.put('I', 1);
        MAP_FROM.put('V', 5);
        MAP_FROM.put('X', 10);
        MAP_FROM.put('L', 50);
        MAP_FROM.put('C', 100);
        MAP_FROM.put('D', 500);
        MAP_FROM.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(toRoman(40 ));
        System.out.println(toRoman(1990 ));
        System.out.println(toRoman(2906));
        System.out.println(toRoman(4));
        System.out.println(toRoman(404));
        System.out.println(toRoman(4004));
        System.out.println(toRoman(2009));
        System.out.println(toRoman(2));
        System.out.println(toRoman(99));
        System.out.println();
        System.out.println(fromRoman("II"));
        System.out.println(fromRoman("MCMXC"));
        System.out.println(fromRoman("MMVIII"));
        System.out.println(fromRoman("VI"));
        System.out.println(fromRoman("IV"));
        System.out.println(fromRoman("MMCMVI"));
        System.out.println(fromRoman("MMCMDVI"));
    }

    public static String toRoman(int n) {

        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {
            for (Map.Entry<Integer, Character> e : MAP_TO.entrySet()
            ) {
                if (n == 4) {
                    n = 0;
                    stringBuilder.append("IV");
                }
                if (n == 9) {
                    n = 0;
                    stringBuilder.append("IX");
                }
                if (n >= 40 && n < 50) {
                    n = n - 40;
                    stringBuilder.append("XL");
                }
                if (n >= 90 && n < 100) {
                    n = n - 90;
                    stringBuilder.append("XC");
                }
                if (n >= 400 && n < 500) {
                    n = n - 400;
                    stringBuilder.append("CD");
                }
                if (n >= 900 && n < 1000) {
                    n = n - 900;
                    stringBuilder.append("CM");
                }
                while (n - e.getKey() >= 0) {
                    n = n - e.getKey();
                    stringBuilder.append(e.getValue());
                }
            }
        }
        return stringBuilder.toString();
    }

    public static int fromRoman(String romanNumeral) {
        StringBuilder stringBuilderReverse = new StringBuilder(romanNumeral).reverse();
        char[] chars = stringBuilderReverse.toString().toCharArray();
        int result = 0;
        int previous = 0;
        for (char c : chars
        ) {
            Integer integer = MAP_FROM.get(c);
            if (integer >= previous) {
                result += integer;
            } else {
                result -= integer;
            }
            previous = integer;
        }

        return result;
    }


}
