package training.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceShould {

    private final int AMOUNT = 1000;

    @Mock
    private TransactionService transactionService;
    @Mock
    private PrintStatementService printStatementService;
    @InjectMocks
    private AccountService accountService;

    @AfterEach
    void noMoreInteraction() {
        verifyNoMoreInteractions(transactionService);
        verifyNoMoreInteractions(printStatementService);
    }

    @Test
    void send_deposit_transaction_with_position_amount() {
        accountService.deposit(AMOUNT);

        verify(transactionService, times(1)).create(AMOUNT);
    }


    @Test
    void send_withdraw_transaction_with_negative_amount() {
        accountService.withdraw(AMOUNT);

        verify(transactionService, times(1)).create(-AMOUNT);
    }

    @Test
    void printStatement_is_sent_to_print_statement_service() {
        accountService.printStatement();

        verify(printStatementService, times(1)).print(transactionService.allInChronologicalOrder());
    }
}