package kyu7;


public class FindTheStrayNumber {
    //7 https://www.codewars.com/kata/57f609022f4d534f05000024
    public static void main(String[] args) {
        System.out.println(stray(new int[]{1, 1, 2}));
        System.out.println(stray(new int[]{17, 17, 3, 17, 17, 17, 17}));
    }
    static int stray(int[] numbers) {
        if (numbers == null || numbers.length < 3 ) return  0;
        int base = 0;
        if (numbers[0] == numbers[1]) base = numbers[0];
        if (numbers[0] == numbers[2]) base = numbers[0];
        if (numbers[1] == numbers[2]) base = numbers[1];
        for (int i :numbers
             ) {
            if (i != base ) return i;
        }
        return 0;
    }
}
