package other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Map.Entry;

// Выводит значение элемента который встречается в списке чаще всего

public class ElementOccursMostOften {

    public static <T> T find(List<T> list) {
        HashMap<T, Integer> map = new HashMap<>();
        list.forEach(e -> {
            if (map.containsKey(e)) {
                int count = map.get(e);
                map.put(e, count + 1);
            } else {
                map.put(e, 1);
            }
        });
        return map.entrySet().stream()
                .max(Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    @Test
    public void findTest() {
        List<Integer> list = Arrays.asList(3, 3, 5, 43, 2, 4, 6, 4, 3, 24, 3, 53);
        System.out.println(find(list));
    }
}
