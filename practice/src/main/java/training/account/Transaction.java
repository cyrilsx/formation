package training.account;

import java.time.LocalDate;

public record Transaction(LocalDate transactionDate, int amount, int balance) {
}
