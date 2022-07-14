package other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StreamMain {

    private static final String MILAN = "Milan";
    private static final String CAMBRIDGE = "Cambridge";
    private static final Trader RAULE = new Trader("Raule", CAMBRIDGE);
    private static final Transaction TRANSACTION_2 = new Transaction(RAULE, 2012, 1000);
    private static final Trader MARIO = new Trader("Mario", MILAN);
    private static final Transaction TRANSACTION_3 = new Transaction(MARIO, 2012, 710);
    private static final Transaction TRANSACTION_5 = new Transaction(MARIO, 2012, 700);
    private static final Trader ALAN = new Trader("Alan", CAMBRIDGE);
    private static final Transaction TRANSACTION_6 = new Transaction(ALAN, 2012, 950);
    private static final Trader BRIAN = new Trader("Brian", CAMBRIDGE);
    private static final Transaction TRANSACTION_1 = new Transaction(BRIAN, 2011, 300);
    private static final Transaction TRANSACTION_4 = new Transaction(BRIAN, 2011, 300);
    private static final List<Transaction> TRANSACTION_LIST =
            Arrays.asList(
                    TRANSACTION_1,
                    TRANSACTION_2,
                    TRANSACTION_3,
                    TRANSACTION_4,
                    TRANSACTION_5,
                    TRANSACTION_6
            );

    @Test
    public void test() {

        List<Transaction> transactions1 = TRANSACTION_LIST.stream()
                .filter(t -> t.year() == 2011)
                .sorted(Comparator.comparing(Transaction::value))
                .toList();

        assertIterableEquals(List.of(TRANSACTION_1, TRANSACTION_4), transactions1);

        List<String> cities = TRANSACTION_LIST.stream()
                .map(t -> t.trader().city())
                .distinct()
                .toList();

        assertIterableEquals(List.of(CAMBRIDGE, MILAN), cities);

        List<Transaction> transactions2 = TRANSACTION_LIST.stream()
                .filter(t -> t.trader().city().equals(CAMBRIDGE))
                .sorted(Comparator.comparing(o -> o.trader().name()))
                .toList();

        List<Transaction> expectedList2 =
                List.of(TRANSACTION_2, TRANSACTION_1, TRANSACTION_4, TRANSACTION_6);
        assertEquals(expectedList2.size(), transactions2.size());
        assertTrue(expectedList2.containsAll(transactions2));
        assertTrue(transactions2.containsAll(expectedList2));

        List<Trader> traders1 = TRANSACTION_LIST.stream()
                .map(Transaction::trader)
                .filter(t -> t.city().equals(CAMBRIDGE))
                .sorted(Comparator.comparing(Trader::name))
                .distinct()
                .toList();

        assertIterableEquals(List.of(ALAN, BRIAN, RAULE), traders1);

        String traders = TRANSACTION_LIST.stream()
                .map(t -> t.trader().name())
                .sorted(String::compareTo)
                .distinct()
                .collect(Collectors.joining(" "))
                .trim();

        assertEquals("Alan Brian Mario Raule", traders);

        boolean cambridge = TRANSACTION_LIST.stream()
                .anyMatch(t -> t.trader().city().equals(MILAN));

        assertTrue(cambridge);

        int cambridgeSum = TRANSACTION_LIST.stream()
                .filter(t -> t.trader().city().equals(CAMBRIDGE))
                .mapToInt(Transaction::value)
                .sum();

        assertEquals(2550, cambridgeSum);

        int maxSum = TRANSACTION_LIST.stream()
                .mapToInt(Transaction::value)
                .reduce(Integer::max)
                .orElseThrow();

        assertEquals(1000, maxSum);

        Transaction transaction3 = TRANSACTION_LIST.stream()
                .min(Comparator.comparing(Transaction::value))
                .orElseThrow();

        assertEquals(TRANSACTION_1, transaction3);
    }

    private record Trader(String name, String city) {
    }

    private record Transaction(Trader trader, int year, int value) {
    }
}
