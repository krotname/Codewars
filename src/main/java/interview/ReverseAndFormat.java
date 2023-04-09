package interview;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseAndFormat {

    /**
     * Дана последовательность чисел 1,2,3,4,5,6,7,9,10,11. Ее нужно вывести в формате 11,9,7,6,3,1.
     */
    public static List<Integer> reverseAndFormat(List<Integer> integers) {
        List<Integer> result = integers.stream()
                .filter(x -> x % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .map(x -> x == 5 ? 6 : x)
                .toList();
        return result;
    }

    @Test
    void test() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 9, 10, 11);
        List<Integer> algorithm = reverseAndFormat(integers);
        assertEquals(algorithm, List.of(11, 9, 7, 6, 3, 1));
    }
}
