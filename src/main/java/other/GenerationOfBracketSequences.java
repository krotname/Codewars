package other;

import java.util.ArrayList;

public class GenerationOfBracketSequences {

    public static void main(String[] args) {
        generate(-1).forEach(System.out::println);
        System.out.println("--------");
        generate(0).forEach(System.out::println);
        System.out.println("--------");
        generate(1).forEach(System.out::println);
        System.out.println("--------");
        generate(2).forEach(System.out::println);
        System.out.println("--------");
        generate(3).forEach(System.out::println);
        System.out.println("--------");
        generate(4).forEach(System.out::println);

    }

    private static ArrayList<String> brackets;

    private static ArrayList<String> generate(int n) {
        brackets = new ArrayList<>();
        return recursiveGenerate("", 0, 0, n);
    }

    private static ArrayList<String> recursiveGenerate(String current, int open, int closed, int n) {
        if (current.length() == 2 * n) {
            brackets.add(current);
            return brackets;
        }
        if (open < n) {
            recursiveGenerate(current + "(", open + 1, closed, n);
        }
        if (closed < open) {
            recursiveGenerate(current + ")", open, closed + 1, n);
        }
        return brackets;
    }
}
