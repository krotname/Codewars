package kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//6 https://www.codewars.com/kata/5544c7a5cb454edb3c000047/train/java
// todo not work

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || bounce < 0 || bounce > 1 || window > h) return -1;
        int count = 0;
        while (h > window){
            h = h * bounce;
            count++;
        }

        return count;
    }

    @Test
    public void test1() {
        assertEquals(3, BouncingBall.bouncingBall(3.0, 0.66, 1.5));
    }

    @Test
    public void test2() {
        assertEquals(15, BouncingBall.bouncingBall(30.0, 0.66, 1.5));
    }

}
