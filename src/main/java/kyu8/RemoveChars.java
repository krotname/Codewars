package kyu8;

public class RemoveChars {
    //8
    /*It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string.
     You're given one parameter, the original string. You don't have to worry with strings with less than two characters.*/
    public static void main(String[] args) {
        System.out.println(remove("country")); //ountr
    }
    public static String remove(String str) {
        return str.substring(1, str.length()-1);

    }
}