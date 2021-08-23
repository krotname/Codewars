package kyu7;

import java.util.Arrays;
import java.util.List;


//6
public class Troll {
/*    Trolls are attacking your comment section!

    A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.

    Your task is to write a function that takes a string and return a new string with all vowels removed.

    For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".

    Note: for this kata y isn't considered a vowel*/

    private static Character[] vowel = {'a', 'e', 'i', 'o', 'u'};
    private static List<Character> vowelList = Arrays.asList(vowel);

    public static void main(String[] args) {
        System.out.println(disemvowel("LOL"));
        System.out.println(disemvowel("This website is for losers LOL!"));

    }

    public static String disemvowel(String s){

        StringBuilder result = new StringBuilder();
        for (char c:s.toCharArray()
             ) {
            if (!vowelList.contains(Character.toLowerCase(c))){
                result.append(c);
            }
        }
        return result.toString();
    }
}
