package other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Задача с учебного собеседования на курсе OTUS
// Ищем первый дубликат в массиве чисел

public class OtusInterview {

    private static final String NOT_FOUND = "Массив не содержит дубликатов";

    public OptionalInt findFirstDuplicate(int[] arr) {

        Set<Integer> uniqueElements = new HashSet<>(arr.length, 1.0f);

        for (int i : arr) {
            if (!uniqueElements.add(i))
                return OptionalInt.of(i);
        }
        return OptionalInt.empty();
    }

    public OptionalInt findFirstDuplicateStream(int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>(arr.length, 1.0f);
        return Arrays.stream(arr).filter(i -> !uniqueElements.add(i)).findAny();
    }

    @Test
    public void testStream3() {
        int[] arr = {1, 2, 3, 3};
        OptionalInt firstDuplicate = findFirstDuplicateStream(arr);
        assertEquals(firstDuplicate, OptionalInt.of(3));
        firstDuplicate.ifPresentOrElse(System.out::println, () -> System.out.println(NOT_FOUND));
    }

    @Test
    public void testNotFoundStream() {
        int[] arr = {1, 2, 3, 4};
        OptionalInt firstDuplicate = findFirstDuplicateStream(arr);
        assertEquals(firstDuplicate, OptionalInt.empty());
        firstDuplicate.ifPresentOrElse(System.out::println, () -> System.out.println(NOT_FOUND));
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 3};
        OptionalInt firstDuplicate = findFirstDuplicate(arr);
        assertEquals(firstDuplicate, OptionalInt.of(3));
        firstDuplicate.ifPresentOrElse(System.out::println, () -> System.out.println(NOT_FOUND));
    }

    @Test
    public void testMinus1() {
        int[] arr = {-1, -1, 2, 3};
        OptionalInt firstDuplicate = findFirstDuplicate(arr);
        assertEquals(firstDuplicate, OptionalInt.of(-1));
        firstDuplicate.ifPresentOrElse(System.out::println, () -> System.out.println(NOT_FOUND));
    }

    @Test
    public void testNotFound() {
        int[] arr = {1, 2, 3, 4};
        OptionalInt firstDuplicate = findFirstDuplicate(arr);
        assertEquals(firstDuplicate, OptionalInt.empty());
        firstDuplicate.ifPresentOrElse(System.out::println, () -> System.out.println(NOT_FOUND));
    }
}
