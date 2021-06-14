import java.util.Arrays;
import java.util.List;

public class Vowels {

    public static int getCount(String str) {
        int vowelsCount = 0;

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

        for (char c:str.toCharArray()
             ) {
            if (vowels.contains(String.valueOf(c))){
                vowelsCount++;
            }
        }

        return vowelsCount;
    }

    public static void main(String[] args) {
        System.out.println(getCount("abracadabra"));
    }

}