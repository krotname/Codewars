package kyu7;

public class StringEndsWith {
    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // returns true
        System.out.println(solution("abc", "d")); // returns false
    }
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
}
