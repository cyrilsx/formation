package training.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class TransactionServiceShould {

    public static final Transaction TRANSACTION = new Transaction(LocalDate.now(), 1000, 1000);
    public static final Transaction TRANSACTION_2 = new Transaction(LocalDate.now().minusDays(2), 500, 500);
    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private DateProvider dateProvider;
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void before() {
        given(dateProvider.now()).willReturn(TRANSACTION.transactionDate());
    }

    @Test
    void save_new_transaction_with_new_account() {
        transactionService.create(TRANSACTION.amount());


        verify(transactionRepository, Mockito.times(1)).save(TRANSACTION);
        verify(transactionRepository, Mockito.times(1)).allOrderByDescDate();
        verifyNoMoreInteractions(transactionRepository, dateProvider);
    }

    @Test
    void save_new_transaction_within_existing_transaction() {
        given(transactionRepository.allOrderByDescDate()).willReturn(Collections.singletonList(TRANSACTION));
        var amount = 500;
        transactionService.create(amount);


        verify(transactionRepository, Mockito.times(1)).save(new Transaction(LocalDate.now(), amount, TRANSACTION.amount() + amount));
        verify(transactionRepository, Mockito.times(1)).allOrderByDescDate();
        verifyNoMoreInteractions(transactionRepository, dateProvider);
    }
}