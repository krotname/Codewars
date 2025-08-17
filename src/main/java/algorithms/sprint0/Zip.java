package algorithms.sprint0;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Zip {

    private static List<Integer> zip(List<Integer> a, List<Integer> b, int n) {
        if (n < 0) throw new IllegalArgumentException("n >= 0 required");
        int min = Math.min(n, Math.min(a.size(), b.size()));
        ArrayList<Integer> integers = new ArrayList<>(min * 2);

        for (int i = 0; i < min; i++) {
            integers.add(a.get(i));
            integers.add(b.get(i));
        }
        return integers;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Integer> a = readList(reader);
            List<Integer> b = readList(reader);
            printList(zip(a, b, n), writer);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static <T> void printList(List<T> list, Writer writer) {
        for (T elem : list) {
            try {
                writer.write(String.valueOf(elem));
                writer.write(" ");
            } catch (IOException ignored) {
            }
        }
    }

    @Test
    void test1() {
        List<Integer> integers1 = List.of(1, 5, 6);
        List<Integer> integers2 = List.of(7, 8, 9);
        List<Integer> actualZip = zip(integers1, integers2, 3);

        List<Integer> expected = List.of(1, 7, 5, 8, 6, 9);
        assertEquals(expected, actualZip);
    }

    @Test
    void test2() {
        List<Integer> integers1 = List.of(1, 5, 6);
        List<Integer> integers2 = List.of(7, 8, 9);
        List<Integer> actualZip = zip(integers1, integers2, 0);

        List<Integer> expected = List.of();
        assertEquals(expected, actualZip);
    }
}
