package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SequentialOneY {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/other/SequentialOneYinput.txt"))) {
            String line = br.readLine();
            var count = 0;
            var maxCount = 0;


            while (line != null) {

                for (int i = 0; i < line.length(); i++) {
                    int currentI = Integer.parseInt(line.substring(i, i + 1));
                    if (currentI == 1) {
                        count++;
                    } else {
                        maxCount = Math.max(maxCount, count);
                        count = 0;
                    }
                }
                System.out.println(Math.max(maxCount, count));
                count = 0;
                maxCount = 0;
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
