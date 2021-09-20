package kyu7;

import java.util.regex.Pattern;

public class ValidatePin {
    //7 https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/train/java

    public static void main(String[] args) {
        System.out.println(validatePin("1111"));
        System.out.println(validatePin("11111"));
        System.out.println(validatePin("111111"));
    }

    public static boolean validatePin(String pin) {
        return Pattern.compile("[0-9]{4}|[0-9]{6}").matcher(pin).matches();
        }
}
