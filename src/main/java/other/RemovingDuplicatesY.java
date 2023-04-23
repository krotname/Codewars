package other;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;

public class RemovingDuplicatesY {
    private static int currentInt = Integer.MIN_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine;
            while (!(inputLine = br.readLine()).trim().equals("")) {
                var inputInt = Integer.parseInt(inputLine);
                calc(inputInt).ifPresent(System.out::println);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static OptionalInt calc(int input) {
        if (input != currentInt) {
            currentInt = input;
            return OptionalInt.of(currentInt);
        }
        return OptionalInt.empty();
    }

    @Test
    public void testPrint() {
        calc(800_000).ifPresent(System.out::println);
        calc(800_000).ifPresent(System.out::println);
        calc(800_001).ifPresent(System.out::println);
        calc(800_001).ifPresent(System.out::println);
        calc(800_002).ifPresent(System.out::println);
        calc(800_003).ifPresent(System.out::println);
        calc(800_003).ifPresent(System.out::println);
    }
}
