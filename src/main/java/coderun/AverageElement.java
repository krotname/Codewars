package coderun;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AverageElement {

    /**
     * Для чтения входных данных необходимо получить их
     * из стандартного потока ввода (System.in).
     * Данные во входном потоке соответствуют описанному
     * в условии формату. Обычно входные данные состоят
     * из нескольких строк. Можно использовать более производительные
     * и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.
     * <p>
     * С помощью BufferedReader можно прочитать из стандартного потока:
     * строку -- reader.readLine()
     * число -- int n = Integer.parseInt(reader.readLine());
     * массив чисел известной длины (во входном потоке каждое число на новой строке) --
     * int[] nums = new int[len];
     * for (int i = 0; i < len; i++) {
     * nums[i] = Integer.parseInt(reader.readLine());
     * }
     * последовательность слов в строке --
     * String[] parts = reader.readLine().split(" ");
     * <p>
     * Чтобы вывести результат в стандартный поток вывода (System.out),
     * Через BufferedWriter можно использовать методы
     * writer.write("Строка"), writer.write('A') и writer.newLine().
     * <p>
     * Возможное решение задачи "Вычислите сумму чисел в строке":
     * int sum = 0;
     * String[] parts = reader.readLine().split(" ");
     * for (int i = 0; i < parts.length; i++) {
     * int num = Integer.parseInt(parts[i]);
     * sum += num;
     * }
     * writer.write(String.valueOf(sum));
     */

    @Test
    public void test() {
        assertEquals(3, average(new String[]{"3", "1", "3"}));
        assertEquals(0, average(new String[]{"1000", "-1000", "0"}));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = reader.readLine().trim().split(" ");

        writer.write(String.valueOf(average(parts)));

        reader.close();
        writer.close();
    }

    private static Integer average(String[] list) {
        return Arrays
                .stream(list)
                .sequential()
                .map(Integer::valueOf)
                .sorted()
                .toList()
                .get(1);
    }
}
