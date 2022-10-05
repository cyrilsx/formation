package training.account;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CheckAccountBalanceFeature {
    public static final LogOutPrinter PRINTER = new LogOutPrinter();

    @Mock
    private DateProvider dateProvider;
    private AccountService accountService;


    @BeforeAll
    static void initConsole() {
        System.setOut(PRINTER);
    }

    @BeforeEach
    void init() {
        accountService = ApplicationBuilder.build(dateProvider);
    }

    @Test
    void should_print_statement_according_to_transactions() {
        given(dateProvider.now()).willReturn(LocalDate.of(2022, 10, 4));
        accountService.deposit(1000);
        given(dateProvider.now()).willReturn(LocalDate.of(2022, 10, 5));
        accountService.withdraw(500);

        accountService.printStatement();

        assertThat(PRINTER.all()).isNotEqualToIgnoringWhitespace(
                """
                        DATE       | AMOUNT | BALANCE
                        04/10/2022 |   1000 | 1000
                        05/10/2022 |   -500 |  500
                        """
        );
    }
}