package kyu7;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Printer {
    //7 https://www.codewars.com/kata/56541980fa08ab47a0000040/train/java

    public static String printerError(String s) {
        Matcher matcher = Pattern.compile("[n-z]").matcher(s);
        int error = 0;
        while (matcher.find()) {
            error++;
        }
        return error + "/" + s.length();
    }

    @Test
    public void test() {
        String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", Printer.printerError(s));
    }

}
