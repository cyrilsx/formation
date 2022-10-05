package training.account;

import java.util.*;

public class TransactionRepository {

    NavigableSet<Transaction> transactions = new TreeSet(Comparator.comparing(Transaction::transactionDate));

    public List<Transaction> allOrderByDescDate() {
            return transactions.descendingSet().stream().toList();
    }

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }
}
