package kyu7;

public class StringEndsWith {
    //7 https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d
    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // returns true
        System.out.println(solution("abc", "d")); // returns false
    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
}
