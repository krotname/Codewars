package kyu7;

public class GetSum {
    //7 https://www.codewars.com/kata/55f2b110f61eb01779000053/train/java

    public static void main(String[] args) {
        System.out.println(GetSum(0, 1));
        System.out.println(GetSum(1, 1));
        System.out.println(GetSum(-1, 0));
        System.out.println(GetSum(-1, 2));
    }

    public static int GetSum(int a, int b) {
        return (a + b) * (Math.abs(a - b) + 1) / 2;

/*        int r = 0;
        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
            r += i;
        }
        return r;*/
    }
}
