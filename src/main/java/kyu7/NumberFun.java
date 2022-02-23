package kyu7;

public class NumberFun {

    public static void main(String[] args) {
        System.out.println(findNextSquare(121));
        System.out.println(findNextSquare(625));
        System.out.println(findNextSquare(114));
    }

    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if (sqrt % 1 != 0) return -1;
        return (long) Math.pow(++sqrt, 2);
    }
}
