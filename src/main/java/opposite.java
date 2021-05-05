package codewars;

public class opposite {

    public static void main(String[] args) {
        System.out.println(opposite(1)); // -1
        System.out.println(opposite(-2)); // 2
        System.out.println(opposite(Integer.MAX_VALUE));

    }
    public static int opposite(int number)
    {
        return number * -1;
    }

}
