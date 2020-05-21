package org.parser.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class Transaction {

    private String name;
    private String surname;
    private String srcIban;
    private String dstIban;
    private String amount;

    public BigDecimal getAmountValue() {
        String value = amount.replace(",", ".");
        return new BigDecimal(value.replace("PLN", ""));
    }

}
