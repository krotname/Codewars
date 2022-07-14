package kyu8;

import org.junit.jupiter.api.Test;

public class Opposite {
    //8
    @Test
    public void test() {
        System.out.println(opposite(1)); // -1
        System.out.println(opposite(-2)); // 2
        System.out.println(opposite(Integer.MAX_VALUE));
    }

    public static int opposite(int number) {
        return number * -1;
    }

}
