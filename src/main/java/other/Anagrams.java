package other;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Anagrams {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String string1 = r.readLine();
        String string2 = r.readLine();
        System.out.println(check(string1, string2));
    }

    public static int check(String string1, String string2) {
        if (string1 == null ||
                string2 == null ||
                string1.length() != string2.length()) return 0;
        Set<Character> characters1 = string1.trim().chars().mapToObj(o -> (char) o).collect(Collectors.toSet());
        Set<Character> characters2 = string2.trim().chars().mapToObj(o -> (char) o).collect(Collectors.toSet());
        for (Character character : characters2) {
            if (!characters1.contains(character)) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    public void test() {
        assertEquals(0, check("zprl", "zprc"));
        assertEquals(1, check("qiu", "iuq"));
//        assertEquals(1, check("qiu qwe", "iuq qwe"));
//        assertEquals(1, check("qiu qwe", "iuq  qwe"));
        assertEquals(1, check(" qiu", "iuq "));
        assertEquals(0, check("qiuqiu", "iuq"));
        assertEquals(0, check("qiu", "iuqiuq"));
        assertEquals(1, check("", ""));
        assertEquals(0, check("", "fff"));
        assertEquals(0, check("ddd", ""));
    }
}
