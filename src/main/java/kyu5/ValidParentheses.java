package kyu5;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses {

    //5

    /**
     * Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid. The function should return true if the string is valid, and false if it's invalid.
     * <p>
     * Examples
     * "()"              =>  true
     * ")(()))"          =>  false
     * "("               =>  false
     * "(())((()())())"  =>  true
     * Constraints
     * 0 <= input.length <= 100
     * <p>
     * Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters. Furthermore, the input string may be empty and/or not contain any parentheses at all. Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).
     */

    @Test
    public void testFalse() {
        assertFalse(validParentheses("()V))(K(L])su^(B"));
        assertFalse(validParentheses("s)R)>)/((({Fr((()K4)i)ef8XR"));
        assertFalse(validParentheses("Iz)Lwy(j"));
        assertFalse(validParentheses(")(()))"));
        assertFalse(validParentheses("("));
        assertFalse(validParentheses("((((())))))"));
        assertFalse(validParentheses("((((((())))))"));
    }

    @Test
    public void testTrue() {
        assertTrue(validParentheses("(())((34()())())"));// true
        assertTrue(validParentheses("()")); // true
        assertTrue(validParentheses("((((()))))")); // true
        assertTrue(validParentheses("(())((()))")); // true
    }

    private static boolean validParentheses(String parens) {
        if (parens == null || parens.isEmpty()) {
            return false;
        }
        int check = 0;
        for (char c : parens.toCharArray()
        ) {
            if (c == '(') {
                check++;
            }
            if (c == ')') {
                check--;
            }
            if (check < 0) {
                return false;
            }
        }
        return check == 0;
    }
}
