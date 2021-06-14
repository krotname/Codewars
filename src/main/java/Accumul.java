import java.util.Locale;

public class Accumul {

    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result.append(String.valueOf(s.charAt(i)).toUpperCase());
                } else {
                    result.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
            }
            result.append("-");
        }

        return result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(accum("ZpglnRxqenU"));
    }
}