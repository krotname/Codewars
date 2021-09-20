package kyu7;

public class SquareDigit {
    //7 https://www.codewars.com/kata/546e2562b03326a88e000020/train/java

    public static void main(String[] args) {
        System.out.println(squareDigits(9119)); //811181
        System.out.println(squareDigits(0)); //0
        System.out.println(squareDigits(-1));
    }

    public static int squareDigits(int n) {
        if (n == 0 ) return 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int i = n % 10;
            n /= 10;
            stringBuilder.insert(0, i * i);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
