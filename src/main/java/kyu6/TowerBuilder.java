package kyu6;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TowerBuilder {

    //6 https://www.codewars.com/kata/576757b1df89ecf5bd00073b/train/java

    public static String[] TowerBuilder(int nFloors) {
        String[] strings = new String[nFloors];
        for (int i = 1; i <= nFloors; i++) {
            String string = " ".repeat(nFloors - i) +
                    "*".repeat(i * 2 - 1) +
                    " ".repeat(nFloors - i);
            strings[i - 1] = string;
        }
        return strings;
    }


    @Test
    public void show() {
        for (String s : TowerBuilder.TowerBuilder(9)) {
            System.out.println(s);
        }
    }

    @Test
    public void BasicTests() {
        assertEquals(String.join(",", "*"), String.join(",", TowerBuilder.TowerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", TowerBuilder.TowerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", TowerBuilder.TowerBuilder(3)));
    }
}