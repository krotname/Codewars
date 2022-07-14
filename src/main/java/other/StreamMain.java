package other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    public record Trader(String name, String city) {
    }

    public record Transaction(Trader trader, int year, int value) {
    }

    private static final String MILAN = "Milan";
    private static final String CAMBRIDGE = "Cambridge";

    @Test
    public void test() {
        Trader raule = new Trader("Raule", CAMBRIDGE);
        Trader mario = new Trader("Mario", MILAN);
        Trader alan = new Trader("Alan", CAMBRIDGE);
        Trader brian = new Trader("Brian", CAMBRIDGE);

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raule, 2012, 1000),
                new Transaction(raule, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactionList.stream()
                .filter(t -> t.year() == 2011)
                .sorted(Comparator.comparing(Transaction::value))
                .forEach(System.out::println);
        System.out.println();

        transactionList.stream()
                .map(t -> t.trader().city())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        transactionList.stream()
                .filter(t -> t.trader().city().equals(CAMBRIDGE))
                .sorted(Comparator.comparing(o -> o.trader().name()))
                .forEach(System.out::println);
        System.out.println();

        transactionList.stream()
                .map(Transaction::trader)
                .filter(t -> t.city().equals(CAMBRIDGE))
                .sorted(Comparator.comparing(Trader::name))
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        String traders = transactionList.stream()
                .map(t -> t.trader().name())
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.joining(" "))
                .trim();
        System.out.println(traders);
        System.out.println();

        boolean cambridge = transactionList.stream()
                .anyMatch(t -> t.trader().city().equals(MILAN));
        System.out.println(cambridge);
        System.out.println();

        int cambridgeSum = transactionList.stream()
                .filter(t -> t.trader().city().equals(CAMBRIDGE))
                .mapToInt(Transaction::value)
                .sum();

        System.out.println(cambridgeSum);
        System.out.println();

        int maxSum = transactionList.stream()
                .mapToInt(Transaction::value)
                .reduce(Integer::max)
                .orElseThrow();

        System.out.println(maxSum);
        System.out.println();

        Transaction transaction = transactionList.stream()
                .min(Comparator.comparing(Transaction::value))
                .orElseThrow();

        System.out.println(transaction);
    }
}
