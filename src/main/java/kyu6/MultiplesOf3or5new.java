package kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesOf3or5new {
    // https://www.codewars.com/kata/514b92a657cdc65150000006/train/java

    public int solution(int number) {
        return IntStream.range(0, number)
                .filter(i -> i % 5 == 0 || i % 3 == 0)
                .sum();
    }

    @Test
    public void test() {
        assertEquals(23, new MultiplesOf3or5new().solution(10));
    }

}
