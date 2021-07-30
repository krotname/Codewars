public class StringRepeat {
//8*
/*
        Write a function called repeatStr which repeats the given string string exactly n times.
*/
    public static void main(String[] args) {

        System.out.println(repeatStr(6, "I")); // "IIIIII"
        System.out.println(repeatStr(5, "Hello")); // "HelloHelloHelloHelloHello"
    }

    public static String repeatStr(final int repeat, final String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

}
