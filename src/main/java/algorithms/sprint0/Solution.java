package algorithms.sprint0;// Java

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> arr;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.stream(reader.readLine().strip().split(" "))
                    .map(Integer::parseInt)
                    .toList();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : arr) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

}