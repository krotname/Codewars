package kyu7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePin {
    //7 https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/train/java

    public static void main(String[] args) {
        System.out.println(validatePin("1111"));
        System.out.println(validatePin("11111"));
    }

    public static boolean validatePin(String pin) {
        //todo tests
        final String regex = "\\d\\d\\d\\d";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(pin);
        return matcher.matches();
        }
}
