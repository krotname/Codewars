package kyu7;

public class CountTheDigit {

    public static void main(String[] args) {
        System.out.println(nbDig(11011, 2)); // 9481
        System.out.println(nbDig(5750, 0)); // 4700
        System.out.println(nbDig(10, 0)); // 3
    }

    public static int nbDig(int n, int d) {
        long count = 0;
        for (int i = 0; i <= n; i++) {
            String s = String.valueOf((int) Math.pow(i, 2));
            count += s.chars().filter(ch -> ch == Character.forDigit(d, 10)).count();
        }
        return (int) count;
    }
}
