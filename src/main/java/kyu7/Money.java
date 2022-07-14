package kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Money {

    //7 https://www.codewars.com/kata/563f037412e5ada593000114/train/java

    @Test
    public void test() {
        assertEquals(3, Money.calculateYears(1000,0.05,0.18,1100));
        assertEquals(14 , Money.calculateYears(1000,0.01625,0.18,1200));
        assertEquals(0, Money.calculateYears(1000,0.05,0.18,1000));
    }

    public static int calculateYears(double principal, double interest, double tax, double desired) {
        if (principal >= desired) return 0;
        int years = 0;
        while (principal < desired) {
            double addOneYear = principal * interest;
            principal = principal + (addOneYear - addOneYear * tax);
            years++;
        }
        return years;
    }
}
