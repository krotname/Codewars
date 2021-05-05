package codewars;

public class EvenOrOdd {
    public static void main(String[] args) {

        System.out.println(even_or_odd(6));
        System.out.println(even_or_odd(7));
    }
    public static String even_or_odd(int number) {
        return number%2 == 0 ? "Even" : "Odd";
    }
}
