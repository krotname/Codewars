package kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TwoSum {

    //6 https://www.codewars.com/kata/52c31f8e6605bcc646000082/train/java

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 1}, 4)));;
    }

    private static Stream<Arguments> basicTests() {
        return Stream.of(
                arguments(new int[]{2, 3, 1}, 4, new int[]{0, 0}),
                arguments(new int[]{1, 2, 3}, 4, new int[]{0, 2}),
                arguments(new int[]{1234, 5678, 9012}, 14690, new int[]{1, 2}),
                arguments(new int[]{2, 2, 3}, 444, new int[]{})
        );
    }

    @ParameterizedTest(name = "numbers: {0}, target: {1}, expected: {2}")
    @MethodSource
    @DisplayName("Basic tests")
    public void basicTests(int[] numbers, int target, int[] expected) {
        int[] actual = twoSum(numbers.clone(), target);
        assertArrayEquals(expected, actual);
    }
}

