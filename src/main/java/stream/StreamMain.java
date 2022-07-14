package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Trader Raule = new Trader("Raule", "Cambridge");
        Trader Mario = new Trader("Mario", "Milan");
        Trader Alan = new Trader("Alan", "Cambridge");
        Trader Brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(Brian, 2011, 300),
                new Transaction(Raule, 2012, 1000),
                new Transaction(Raule, 2011, 400),
                new Transaction(Mario, 2012, 710),
                new Transaction(Mario, 2012, 700),
                new Transaction(Alan, 2012, 950)
        );

        transactionList.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println();

        transactionList.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        transactionList.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(o -> o.getTrader().getName()))
                .forEach(System.out::println);
        System.out.println();

        transactionList.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        String traders = transactionList.stream()
                .map(t -> t.getTrader().getName())
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.joining(" "))
                .trim();
        System.out.println(traders);
        System.out.println();

        boolean cambridge = transactionList.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(cambridge);
        System.out.println();

        int cambridgeSum = transactionList.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println(cambridgeSum);
        System.out.println();

        int maxSum = transactionList.stream()
                .mapToInt(Transaction::getValue)
                .reduce(Integer::max)
                .orElseThrow();

        System.out.println(maxSum);
        System.out.println();

        Transaction transaction = transactionList.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElseThrow();

        System.out.println(transaction);


    }
}
