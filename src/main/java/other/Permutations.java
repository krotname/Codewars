package other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// Выводит в консоль все возможные перестановки из массива
// Размещение без повторений (3,3)
// Упорядоченная выборка, элементам в которой повторяться запрещенно

public class Permutations {

    private static final List<int[]> RESULT = new ArrayList<>();

    private static void arrSwap(int[] pa, int i, int j) {
        int k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }

    private static void arrOut(int[] pa) {
        int[] clone = pa.clone();
        for (int i = 0; i < clone.length; i++) {
            clone[i] *= 11;
        }
        RESULT.add(clone);
    }

    public void permutations(int[] pa, int i) {
        if (i == pa.length - 1) {
            arrOut(pa);
        } else {
            for (int j = i; j < pa.length; j++) {
                arrSwap(pa, i, j);
                permutations(pa, i + 1);
                arrSwap(pa, i, j);
            }
        }
    }

    @Test
    public void test() {
        int[] pa = new int[]{1, 2, 3};
        permutations(pa, 0);

        assertArrayEquals(List.of(
                        new int[]{11, 22, 33},
                        new int[]{11, 33, 22},
                        new int[]{22, 11, 33},
                        new int[]{22, 33, 11},
                        new int[]{33, 22, 11},
                        new int[]{33, 11, 22}).toArray(),
                RESULT.toArray());
    }
}
