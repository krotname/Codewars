package kyu5;

public class ValidParentheses {

    //5
/*    Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid. The function should return true if the string is valid, and false if it's invalid.

    Examples
"()"              =>  true
        ")(()))"          =>  false
        "("               =>  false
        "(())((()())())"  =>  true
    Constraints
0 <= input.length <= 100

    Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters. Furthermore, the input string may be empty and/or not contain any parentheses at all. Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).

    */
    public static void main(String[] args) {
        System.out.println(validParentheses("()V))(K(L])su^(B"));// false
        System.out.println(validParentheses("s)R)>)/((({Fr((()K4)i)ef8XR"));// false
        System.out.println(validParentheses("Iz)Lwy(j"));// false
        System.out.println(validParentheses(")(()))"));// false
        System.out.println(validParentheses("("));// false
        System.out.println(validParentheses("((((())))))")); // false
        System.out.println(validParentheses("((((((())))))")); // false
        System.out.println(validParentheses("(())((34()())())"));// true
        System.out.println(validParentheses("()")); // true
        System.out.println(validParentheses("((((()))))")); // true
        System.out.println(validParentheses("(())((()))")); // true
    }

    private static boolean validParentheses(String parens) {
        if (parens == null || parens.isEmpty()) {return false;}
        int check = 0;
        for (char c : parens.toCharArray()
        ) {
            if (c == '(') {
                check++;
            }
            if (c == ')') {
                check--;
            }
            if (check < 0) {return false;}
        }
        return check == 0;
    }
}
