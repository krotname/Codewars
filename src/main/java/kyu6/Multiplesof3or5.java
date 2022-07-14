package kyu6;

import org.junit.jupiter.api.Test;

public class Multiplesof3or5 {

    //6

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * <p>
     * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally, if the number is negative, return 0 (for languages that do have them).
     * <p>
     * Note: If the number is a multiple of both 3 and 5, only count it once.
     */

    @Test
    public void test() {
        System.out.println(solution(10)); //23
        System.out.println(solution(100)); //2318
    }

    public static int solution(int number) {
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (i % 5 == 0 || i % 3 == 0) result += i;
        }
        return result;
    }
}
