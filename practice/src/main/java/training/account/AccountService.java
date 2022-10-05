package training.account;

public class AccountService {

    private final TransactionService transactionService;
    private final PrintStatementService printStatementService;

    public AccountService(TransactionService transactionService, PrintStatementService printStatementService) {
        this.transactionService = transactionService;
        this.printStatementService = printStatementService;
    }

    public void deposit(int amount) {
        transactionService.create(amount);
    }

    public void withdraw(int amount) {
        transactionService.create(-amount);
    }

    public void printStatement() {
        printStatementService.print(transactionService.allInChronologicalOrder());
    }
}
