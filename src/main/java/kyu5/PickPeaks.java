package kyu5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PickPeaks {
    public static void main(String[] args) {
        Map<String, List<Integer>> peaks = getPeaks(new int[]{1, 2, 3, 6, 4, 1, 2, 3, 2, 1});
        Map<String, List<Integer>> peaks1 = getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3});
        Map<String, List<Integer>> peaks2 = getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1});
        System.out.println(peaks.get("pos"));
        System.out.println(peaks.get("peaks"));
    }

    /*       /\     /--\
     *   \  /  \   /    \  вверх vector true, а вниз false
     *    \/    \_/
     * */

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> peaks = new LinkedHashMap<>();
        peaks.put("pos", new ArrayList<>());
        peaks.put("peaks", new ArrayList<>());
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
                    peaks.get("pos").add(lastChangeVectorIndex);
                    peaks.get("peaks").add(lastChangeVector);
                }
                vector = false;
                lastChangeVector = arr[i];
                lastChangeVectorIndex = i;
            }
        }
        return peaks;
    }
}