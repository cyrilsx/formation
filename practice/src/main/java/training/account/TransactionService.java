package training.account;

import java.util.List;

public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final DateProvider dateProvider;

    public TransactionService(TransactionRepository transactionRepository, DateProvider dateProvider) {
        this.transactionRepository = transactionRepository;
        this.dateProvider = dateProvider;
    }

    public void create(int amount) {
        List<Transaction> transactions = transactionRepository.allOrderByDescDate();
        int balance = transactions.isEmpty() ? 0 :transactions.get(transactions.size()-1).balance();

        Transaction transaction = new Transaction(dateProvider.now(), amount, balance + amount);
        transactionRepository.save(transaction);
    }

    public List<Transaction> allInChronologicalOrder() {
        return transactionRepository.allOrderByDescDate();
    }
}
