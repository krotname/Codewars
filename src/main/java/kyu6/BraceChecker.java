package kyu6;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// 6 https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/java

public class BraceChecker {

    public static boolean isValid(String braces) {
        var bracketsStack = new LinkedList<Character>();
        for (Character c : braces.toCharArray()) {
            if (c == '(') bracketsStack.add(c);
            if (c == '[') bracketsStack.add(c);
            if (c == '{') bracketsStack.add(c);
            if (c == ')') {
                if (!bracketsStack.isEmpty() && Objects.equals(bracketsStack.peekLast(), '(')) {
                    bracketsStack.removeLast();
                } else return false;
            }
            if (c == ']') {
                if (!bracketsStack.isEmpty() && Objects.equals(bracketsStack.peekLast(), '[')) {
                    bracketsStack.removeLast();
                } else return false;
            }
            if (c == '}') {
                if (!bracketsStack.isEmpty() && Objects.equals(bracketsStack.peekLast(), '{')) {
                    bracketsStack.removeLast();
                } else return false;
            }

        }
        return bracketsStack.isEmpty();
    }

    @Test
    public void testValid1() {
        assertTrue(isValid("()"));
    }

    @Test
    public void testValid2() {
        assertTrue(isValid("[()]"));
    }

    @Test
    public void testValid3() {
        assertTrue(isValid("(({{[[]]}}))"));
    }

    @Test
    public void testValid4() {
        assertTrue(isValid("{}({})[]"));
    }

    @Test
    public void testInvalid1() {
        assertFalse(isValid("[(])"));
    }

    @Test
    public void testInvalid2() {
        assertFalse(isValid("[(]))"));
    }

    @Test
    public void testInvalid3() {
        assertFalse(isValid("][)("));
    }

    @Test
    public void testInvalid4() {
        assertFalse(isValid("(})"));
    }
}
