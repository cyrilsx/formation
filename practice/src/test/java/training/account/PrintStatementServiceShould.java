package training.account;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrintStatementServiceShould {

    public static final LogOutPrinter PRINTER = new LogOutPrinter();

    private final PrintStatementService printStatementService = new PrintStatementService();

    @BeforeAll
    static void initConsole() {
        System.setOut(PRINTER);
    }

    @Test
    void print_statement_from_transactions() {
        List<Transaction> transactions = List.of(
                new Transaction(LocalDate.of(2022, 10, 4), 1000, 1000),
                new Transaction(LocalDate.of(2022, 10, 5), -500, 500)
        );
        printStatementService.print(transactions);

        assertThat(PRINTER.all()).isEqualToIgnoringWhitespace(
                """
                        DATE       | AMOUNT | BALANCE
                        04/10/2022|1000|1000
                        05/10/2022|-500|500
                        """
        );
    }
}