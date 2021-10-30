package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader Raule = new Trader("Raule", "Cambridge");
        Trader Mario = new Trader("Mario", "Milane");
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

        transactionList.stream()
                .map(a -> a.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);


    }
}
