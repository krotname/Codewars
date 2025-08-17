package algorithms.sprint0;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long sum = sum(a, b);
        System.out.println(sum);
    }

    public static long sum(int a, int b) {
        return a + b;
    }

    @Test
    public void test() {
        assertEquals(5, sum(2, 3));
        assertEquals(-1, sum(-2, 1));
    }
}
