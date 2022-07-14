package kyu8;

import org.junit.jupiter.api.Test;

public class EvenOrOdd {
    //8

    @Test
    public void test() {
        System.out.println(evenOrOdd(6));
        System.out.println(evenOrOdd(7));
    }

    public static String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }
}
