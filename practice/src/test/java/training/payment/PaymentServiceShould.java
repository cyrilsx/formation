package training.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PaymentServiceShould {

    @Mock
    private PaymentGateway paymentGateway;
    @Mock
    private FraudService fraudService;
    @InjectMocks
    private PaymentService paymentService;

    @Test
    void payment_refuse_if_fraud() {
        given(fraudService.isFraud(any(), any())).isTrue();

        assertThatThrownBy(() -> paymentService.processPayment(new User("toto"), new PaymentDetails(1000)))
                .isInstanceOf(PaymentRefusedException.class);
    }
}