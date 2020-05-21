package org.parser.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Transfer {

    private final String name;
    private final String surname;
    private final String sourceIban;
    private final String destinationIban;
    private final String amount;

}
