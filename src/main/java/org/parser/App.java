package org.parser;

import org.parser.model.Transaction;
import org.parser.reader.TransactionReader;
import org.parser.service.TransactionService;

import java.math.BigDecimal;
import java.util.List;

public class App {

    public static void main( String[] args ) {
        TransactionReader reader = new TransactionReader();
        TransactionService service = new TransactionService();
        List<Transaction> transactions = reader.readTransactionsFromFile(args[0]);
        BigDecimal sum = service.sumAmounts(transactions);
        System.out.println(sum);
    }

}
