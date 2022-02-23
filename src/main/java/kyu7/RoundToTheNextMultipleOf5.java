package kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundToTheNextMultipleOf5 {

    //7 https://www.codewars.com/kata/55d1d6d5955ec6365400006d/train/java

    public static int roundToNext5(int number) {
        int i = number % 5;
        if (number < 0) {
            return (number - i);
        } else {
            return (i == 0 ? number : number - i + 5);
        }
    }

    @Test
    public void basicTests() {
        int[][] arr = {
                {0, 0},
                {1, 5},
                {3, 5},
                {5, 5},
                {7, 10},
                {-1, 0},
                {-857568, -857565},
                {-5, -5},
                {39, 40}
        };
        Arrays.stream(arr)
                .forEach(
                        (testCase) -> {
                            assertEquals(
                                    testCase[1],
                                    RoundToTheNextMultipleOf5.roundToNext5(testCase[0]));
                        });
    }


}
