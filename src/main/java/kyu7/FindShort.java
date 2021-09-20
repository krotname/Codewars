package kyu7;

public class FindShort {
    //7 https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9/train/java
    public static void main(String[] args) {
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps")); //3
        System.out.println(findShort("bitcoin ")); //7
    }

    public static int findShort(String s) {
        if (s == null || s.length() == 0) return 0;
        if (!s.contains(" ")) return s.length();
        int min = Integer.MAX_VALUE;
        for (String s1 : s.split(" ")) {
            min = Math.min(min, s1.length());
        }
        return min;
    }
}
