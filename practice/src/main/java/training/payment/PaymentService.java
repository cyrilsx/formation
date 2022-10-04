package training.payment;

public class PaymentService {
    private final PaymentGateway paymentGateway;
    private final FraudService fraudService;

    public PaymentService(PaymentGateway paymentGateway, FraudService fraudService) {
        this.paymentGateway = paymentGateway;
        this.fraudService = fraudService;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {
        if (this.fraudService.isFraud(user, paymentDetails)) {
            throw new PaymentRefusedException();
        }
        paymentGateway.doPayment(paymentDetails);
    }
}
