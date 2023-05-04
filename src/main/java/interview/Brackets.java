package interview;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Brackets {

    /**
     * Дана произвольная строка, в которой могут встречаться разные виды скобок “()[]{}“ в произвольном порядке. Нужно проверить согласованность скобок
     */

    @Test
    public void test() {
        assertTrue(check("()[]{}"));
        assertTrue(check("((){{}[]{[]}})"));
        assertFalse(check("((){{[}]{[]}})"));
        assertFalse(check("((){{}[{[]}})"));
        assertFalse(check("]((){{}{[]}})"));
        assertFalse(check("{{))"));


    }

    public static boolean check(String string) {
        LinkedList<Character> bracket = new LinkedList<>();
        Map<Character, Character> bracketsMap = Map.of(')', '(', ']', '[', '}', '{');

        char[] chars = string.toCharArray();

        for (char aChar : chars) {
            if (bracketsMap.containsValue(aChar)) {
                bracket.add(aChar);
            }

            if ((bracketsMap.containsKey(aChar))) {
                Character character = bracket.peekLast();
                if (Objects.isNull(character) || bracket.peekLast() != bracketsMap.get(aChar)) {
                    return false;
                } else {
                    bracket.removeLast();
                }
            }
        }
        return bracket.isEmpty();
    }
}
