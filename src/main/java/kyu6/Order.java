package kyu6;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    //6 https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java

    /**
     * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
     * <p>
     * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
     * <p>
     * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
     * <p>
     * Examples
     * "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
     * "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
     * ""  -->  ""
     */

    @Test
    public void test() {
        System.out.println(Order.order("is2 Thi1s T4est 3a")); // Thi1s is2 3a T4est
        System.out.println(Order.order("4of Fo1r pe6ople g3ood th5e the2")); // Fo1r the2 g3ood 4of th5e pe6ople
    }

    public static String order(String words) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<Integer, String> stringIntegerHashMap = new TreeMap<>();


        String[] s = words.split("\\s");

        for (String str : s) {
            stringIntegerHashMap.put(getInt(str), str);
        }

        for (Map.Entry<Integer, String> entry : stringIntegerHashMap.entrySet()) {
            stringBuilder.append(entry.getValue()).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    private static int getInt(String word) {
        final String regex = "[0-9]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        }
        return 0;
    }
}
