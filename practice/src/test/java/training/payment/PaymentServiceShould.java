package training.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertThatThrownBy(() -> paymentService.processPayment(new User("toto"), new PaymentDetails(1000)))
                .isInstanceOf(PaymentRefusedException.class);
    }
}