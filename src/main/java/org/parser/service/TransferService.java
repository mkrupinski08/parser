package org.parser.service;

import org.parser.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public class TransferService {

    private static final String CURRENCY = "PLN";

    public BigDecimal sumAmounts(List<Transfer> transferList) {
        return transferList.stream()
                .map(this::getAmountValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getAmountValue(Transfer transfer) {
        String value = transfer.getAmount().replace(",", ".");
        return new BigDecimal(value.replace(CURRENCY, ""));
    }

}
