package transactions;

import java.util.List;

interface ValidationService {

    static ValidationService getInstance() {
        return new InMemoryValidationService();
    }

    ValidationResult validate(List<Transaction> transactions, long balance);
}
