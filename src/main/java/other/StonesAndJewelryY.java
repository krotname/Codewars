package other;

import java.io.*;
import java.util.Objects;
import java.util.stream.Collectors;

public class StonesAndJewelryY {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String jewelry = r.readLine();
        String stones = r.readLine();

        if (Objects.isNull(jewelry) || Objects.isNull(stones)) return;
        var setJewelry = jewelry
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        char[] stonesChars = stones.toCharArray();
        int count = 0;
        for (char stonesChar : stonesChars) {
            if (setJewelry.contains(stonesChar)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
