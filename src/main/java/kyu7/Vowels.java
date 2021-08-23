package kyu7;

import java.util.Arrays;
import java.util.List;

public class Vowels {
    //7
    /*Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.*/

    public static int getCount(String str) {
        int vowelsCount = 0;

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

        for (char c:str.toCharArray()
             ) {
            if (vowels.contains(String.valueOf(c))){
                vowelsCount++;
            }
        }

        return vowelsCount;
    }

    public static void main(String[] args) {
        System.out.println(getCount("abracadabra"));
    }

}