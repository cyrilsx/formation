package training.payment;

public interface FraudService {

    boolean isFraud(User user, PaymentDetails paymentDetails);
}
