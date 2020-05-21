package org.parser.service;

import org.parser.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class TransactionService {

    public BigDecimal sumAmounts(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getAmountValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
