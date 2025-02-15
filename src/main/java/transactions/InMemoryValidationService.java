package transactions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class InMemoryValidationService implements ValidationService {


    /**
     * 1. Транзакции обрабатываются по порядку transaction.getId();
     * 2. Транзакция с id, который был обработан, считается невалидной;
     * 3. Транзакции с таким же orderId, как у невалидной транзакции, тоже считаются невалидными;
     * 4. BET транзакция понижает баланс;
     * 5. WIN транзакция повышает баланс;
     * 6. Если BET транзакция делает баланс отрицательным, то она считается невалидной.
     **/

    @Override
    public ValidationResult validate(List<Transaction> transactions, long balance) {
        if (transactions == null || transactions.isEmpty() || balance < 0) {
            return ValidationResult.empty();
        }

        List<Transaction> sortedTransactions = transactions.stream()
                .sorted()
                .toList();

        Set<Long> transactionsIds = new HashSet<>();
        Set<Long> failedOrderIds = new HashSet<>();

        List<TransactionStatus> transactionStatuses = new ArrayList<>();

        for (Transaction transaction : sortedTransactions) {
            boolean condition = transactionsIds.contains(transaction.id())
                    || failedOrderIds.contains(transaction.orderId());

            if (condition) {
                transactionStatuses.add((new TransactionStatus(transaction, false)));
                failedOrderIds.add(transaction.orderId());
                transactionsIds.add(transaction.id());
                continue;
            }

            if (transaction.type() == TransactionType.BET) {
                boolean negativeBalance = balance < transaction.amount();

                if (negativeBalance) {
                    transactionStatuses.add(new TransactionStatus(transaction, false));
                    failedOrderIds.add(transaction.orderId());
                } else {
                    balance -= transaction.amount();
                    transactionStatuses.add(new TransactionStatus(transaction, true));
                }
            }

            if (transaction.type() == TransactionType.WIN) {
                balance += transaction.amount();
                transactionStatuses.add(new TransactionStatus(transaction, true));
            }
            transactionsIds.add(transaction.id());

        }

        return new ValidationResult(transactionStatuses);
    }
}