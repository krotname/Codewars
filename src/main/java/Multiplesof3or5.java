package codewars;

public class Multiplesof3or5 {
    public static void main(String[] args) {
        System.out.println(solution(10)); //23
        System.out.println(solution(100)); //2318
    }
    public static int solution(int number) {
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (i%5 == 0 || i%3 == 0) result += i;
        }
        return result;
    }
}
