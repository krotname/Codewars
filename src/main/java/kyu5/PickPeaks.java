package kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickPeaks {

    private static final String POS = "pos";
    private static final String PEAKS = "peaks";

    /**
     * /\     /--\
     * \  /  \   /    \  вверх vector true, а вниз false
     * \/    \_/
     */

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> peaks = new LinkedHashMap<>();
        peaks.put(POS, new ArrayList<>());
        peaks.put(PEAKS, new ArrayList<>());
        if (arr == null || arr.length == 0) return peaks;
        boolean vector = false;
        int lastChangeVector = arr[0];
        int lastChangeVectorIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > lastChangeVector) {
                vector = true;
                lastChangeVector = arr[i];
                lastChangeVectorIndex = i;
            }
            if (arr[i] < lastChangeVector) {
                if (vector) {
                    peaks.get(POS).add(lastChangeVectorIndex);
                    peaks.get(PEAKS).add(lastChangeVector);
                }
                vector = false;
                lastChangeVector = arr[i];
                lastChangeVectorIndex = i;
            }
        }
        return peaks;
    }

    @Test
    public void test1() {
        Map<String, List<Integer>> peaks = getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1});

        assertEquals(List.of(3, 7, 10), peaks.get(POS));
        assertEquals(List.of(6, 3, 2), peaks.get(PEAKS));
    }

    @Test
    public void test2() {
        Map<String, List<Integer>> peaks = getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3});
        assertEquals(List.of(3, 7), peaks.get(POS));
        assertEquals(List.of(6, 3), peaks.get(PEAKS));
    }

    @Test
    public void test3() {
        Map<String, List<Integer>> peaks = getPeaks(new int[]{1, 2, 3, 6, 4, 1, 2, 3, 2, 1});
        assertEquals(List.of(3, 7), peaks.get(POS));
        assertEquals(List.of(6, 3), peaks.get(PEAKS));
    }
}