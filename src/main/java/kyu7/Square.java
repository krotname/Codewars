package kyu7;

public class Square {
    //7 https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java
    public static void main(String[] args) {
        System.out.println(isSquare(4));
        System.out.println(isSquare(3));

    }

    public static boolean isSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }
}
