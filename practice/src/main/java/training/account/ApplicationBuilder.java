package training.account;

import java.awt.dnd.DropTarget;

public class ApplicationBuilder {

    public static AccountService build(DateProvider dateProvider) {
        PrintStatementService printStatementService = new PrintStatementService();

        TransactionRepository transactionRepository = new TransactionRepository();
        TransactionService transactionService = new TransactionService(transactionRepository, dateProvider);
        return new AccountService(transactionService, printStatementService);
    }
}
