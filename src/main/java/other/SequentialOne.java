package other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialOne {

    public int calculate(String integers){
        var count = 0;
        var maxCount = 0;

        for (int i = 0; i < integers.length(); i++) {
            if (Integer.parseInt(integers.substring(i, i+1)) == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    @Test
    public void testPrint(){
        for (int i = 0; i < 21000; i++) {
            System.out.println(i + " -- "+  calculate(String.valueOf(i)));
        }
    }
    @Test
    public void test(){
         assertEquals(5, calculate(String.valueOf(11111)));
         assertEquals(2, calculate(String.valueOf(1011)));
         assertEquals(3, calculate(String.valueOf(10111)));
         assertEquals(3, calculate(String.valueOf(11100)));
    }


}
