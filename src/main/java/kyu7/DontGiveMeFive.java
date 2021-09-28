package kyu7;

public class DontGiveMeFive {
    //7 https://www.codewars.com/kata/5813d19765d81c592200001a/solutions/java

    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(1, 9)); //8
        System.out.println(dontGiveMeFive(4, 17)); //12
    }

    public static int dontGiveMeFive(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (!String.valueOf(i).contains("5")) count++;
        }
        return count;
    }
}
