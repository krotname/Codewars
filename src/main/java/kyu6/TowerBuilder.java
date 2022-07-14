package kyu6;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TowerBuilder {

    //6 https://www.codewars.com/kata/576757b1df89ecf5bd00073b/train/java

    @Test
    public void basicTests() {
        assertEquals(String.join(",", "*"), String.join(",", towerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", towerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", towerBuilder(3)));
    }

    @Test
    public void showTest() {
        assertEquals(
                "        *        " + System.lineSeparator() +
                        "       ***       " + System.lineSeparator() +
                        "      *****      " + System.lineSeparator() +
                        "     *******     " + System.lineSeparator() +
                        "    *********    " + System.lineSeparator() +
                        "   ***********   " + System.lineSeparator() +
                        "  *************  " + System.lineSeparator() +
                        " *************** " + System.lineSeparator() +
                        "*****************" + System.lineSeparator(),
                show());
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (String s : TowerBuilder.towerBuilder(9)) {
            sb.append(s).append(System.lineSeparator());
        }
        return sb.toString();
    }


    public static String[] towerBuilder(int nFloors) {
        String[] strings = new String[nFloors];
        for (int i = 1; i <= nFloors; i++) {
            String string = " ".repeat(nFloors - i) +
                    "*".repeat(i * 2 - 1) +
                    " ".repeat(nFloors - i);
            strings[i - 1] = string;
        }
        return strings;
    }

}