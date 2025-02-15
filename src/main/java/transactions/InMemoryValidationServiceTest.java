package transactions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryValidationServiceTest {

    private final ValidationService service = ValidationService.getInstance();

    private Transaction createTransaction(long id, long orderId, long amount, TransactionType type) {
        return new Transaction(id, orderId, amount, type);
    }

    @Test
    void testNullTransactions() {
        ValidationResult result = service.validate(null, 100);
        assertTrue(result.getTransactions().isEmpty(), "Result should be empty for null transactions");
    }

    @Test
    void testEmptyTransactions() {
        ValidationResult result = service.validate(List.of(), 100);
        assertTrue(result.getTransactions().isEmpty(), "Result should be empty for empty transactions");
    }

    @Test
    void testNegativeInitialBalance() {
        List<Transaction> transactions = List.of(createTransaction(1, 1, 50, TransactionType.BET));
        ValidationResult result = service.validate(transactions, -10);
        assertTrue(result.getTransactions().isEmpty(), "Result should be empty for negative initial balance");
    }

    @Test
    void testValidBetTransaction() {
        List<Transaction> transactions = List.of(createTransaction(1, 1, 50, TransactionType.BET));
        ValidationResult result = service.validate(transactions, 100);
        List<TransactionStatus> statuses = result.getTransactions();
        assertEquals(1, statuses.size(), "There should be one transaction status");
        assertTrue(statuses.getFirst().status(), "BET transaction should be valid when balance is sufficient");
    }

    @Test
    void testInvalidBetTransactionDueToInsufficientBalance() {
        List<Transaction> transactions = List.of(createTransaction(1, 1, 150, TransactionType.BET));
        ValidationResult result = service.validate(transactions, 100);
        List<TransactionStatus> statuses = result.getTransactions();
        assertEquals(1, statuses.size(), "There should be one transaction status");
        assertFalse(statuses.getFirst().status(), "BET transaction should be invalid due to insufficient balance");
    }

    @Test
    void testWinTransactionIncreasesBalance() {
        // WIN-транзакция увеличивает баланс, позволяя последующей BET-транзакции пройти валидацию
        Transaction win = createTransaction(1, 1, 50, TransactionType.WIN);
        Transaction bet = createTransaction(2, 2, 120, TransactionType.BET);
        List<Transaction> transactions = List.of(win, bet);
        ValidationResult result = service.validate(transactions, 100);
        List<TransactionStatus> statuses = result.getTransactions();
        assertEquals(2, statuses.size(), "There should be two transaction statuses");
        assertTrue(statuses.get(0).status(), "WIN transaction should be valid");
        assertTrue(statuses.get(1).status(), "BET transaction should be valid after balance increase");
    }

    @Test
    void testDuplicateTransactionId() {
        Transaction t1 = createTransaction(1, 1, 50, TransactionType.WIN);
        // Повторное использование id 1 должно пометить вторую транзакцию как невалидную
        Transaction t2 = createTransaction(1, 2, 30, TransactionType.BET);
        List<Transaction> transactions = List.of(t1, t2);
        ValidationResult result = service.validate(transactions, 100);
        List<TransactionStatus> statuses = result.getTransactions();
        assertEquals(2, statuses.size(), "There should be two transaction statuses");
        assertTrue(statuses.get(0).status(), "First transaction should be valid");
        assertFalse(statuses.get(1).status(), "Duplicate transaction id should mark second transaction invalid");
    }

    @Test
    void testFailedOrderIdAffectsSubsequentTransactions() {
        // Первая транзакция не проходит валидацию из-за недостатка средств
        Transaction bet1 = createTransaction(1, 10, 150, TransactionType.BET);
        // Вторая транзакция с тем же orderId должна быть невалидной вне зависимости от типа
        Transaction win1 = createTransaction(2, 10, 100, TransactionType.WIN);
        List<Transaction> transactions = List.of(bet1, win1);
        ValidationResult result = service.validate(transactions, 100);
        List<TransactionStatus> statuses = result.getTransactions();
        assertEquals(2, statuses.size(), "There should be two transaction statuses");
        assertFalse(statuses.get(0).status(), "First transaction should be invalid due to insufficient funds");
        assertFalse(statuses.get(1).status(), "Transaction with same order id as failed transaction should be invalid");
    }

    @Test
    void testTransactionsProcessedInOrder() {
        // Транзакции заданы не по порядку: сначала BET (id 2), затем WIN (id 1).
        // После сортировки они должны обрабатываться в правильном порядке.
        Transaction bet = createTransaction(2, 1, 50, TransactionType.BET);
        Transaction win = createTransaction(1, 2, 100, TransactionType.WIN);
        List<Transaction> transactions = List.of(bet, win);
        // Начальный баланс 50, после обработки WIN становится 150, затем BET списывает 50 -> итог 100
        ValidationResult result = service.validate(transactions, 50);
        List<TransactionStatus> statuses = result.getTransactions();
        assertEquals(2, statuses.size(), "There should be two transaction statuses");
        assertTrue(statuses.get(0).status(), "First processed transaction should be valid");
        assertTrue(statuses.get(1).status(), "Second processed transaction should be valid");
    }
}
