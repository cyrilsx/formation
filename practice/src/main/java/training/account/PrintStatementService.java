package training.account;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class PrintStatementService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void print(List<Transaction> transactions) {
        System.out.println("DATE       | AMOUNT | BALANCE");
        transactions.forEach(transaction -> System.out.println(DATE_TIME_FORMATTER.format(transaction.transactionDate()) + "|" + transaction.amount() + "|"+ transaction.balance()));
    }

}
