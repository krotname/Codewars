package other;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalDouble;

public class RemovingDuplicatesY {
    private static double currentInt = Double.MIN_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputLine;
            while (!(inputLine = br.readLine()).trim().equals("")) {
                var inputInt = Double.parseDouble(inputLine);
                calc(inputInt).ifPresent(System.out::println);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static OptionalDouble calc(double input) {
        if (input != currentInt) {
            currentInt = input;
            return OptionalDouble.of(currentInt);
        }
        return OptionalDouble.empty();
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
