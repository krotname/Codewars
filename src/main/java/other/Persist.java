package other;

public class Persist {
    public static void main(String[] args) {
        System.out.println(persistence(39));
        System.out.println(persistence(999));
        System.out.println(persistence(4));
    }

    public static int persistence(long n) {
        int result = 0;
        while (n > 9) {
            char[] s = String.valueOf(n).toCharArray();
            int temp = Integer.parseInt(String.valueOf(s[0]));
            for (int i = 1; i < s.length; i++) {
                temp *= Integer.parseInt(String.valueOf(s[i]));
            }
            n = temp;
            result++;
        }
        return result;
    }
}
