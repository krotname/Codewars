package kyu7;

public class Maskify {
    //7 https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java
    public static void main(String[] args) {
        System.out.println(maskify("4556364607935616"));
        System.out.println(maskify("455636460"));
        System.out.println(maskify("45555"));
        System.out.println(maskify("4555"));
        System.out.println(maskify("455"));
    }
    public static String maskify(String str) {
        if (str.length() < 5) return str;
        return "#".repeat(str.length() - 4) + str.substring(str.length() - 4);
    }
}
