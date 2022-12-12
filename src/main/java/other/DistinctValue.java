package other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DistinctValue {
    private static final ArrayList<Integer> integers = new ArrayList<>();

    static {
        for (Integer i = 0; i < 100_000; i++) {
            integers.add((int) (Math.random() * 100_000));
        }
    }

    public static <T> List<T> find(List<T> l) {
        List<T> u = new ArrayList<>();

        l.forEach(e -> {
            if (!u.contains(e)) {
                u.add(e);
            }
        });
        return u;
    }

    public static <T> List<T> findOptimal(List<T> l) {
        return l.stream().distinct().toList();
    }

    @Test
    void find() {
        find(integers);
    }

    @Test
    void findOptimal() {
        findOptimal(integers);
    }
}
