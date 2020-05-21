package org.parser;

import org.parser.model.Transfer;
import org.parser.reader.TransferReader;
import org.parser.service.TransferService;

import java.math.BigDecimal;
import java.util.List;

public class App {

    public static void main(String[] args) {

        TransferReader reader = new TransferReader();
        TransferService service = new TransferService();

        List<Transfer> transferList = reader.readTransferListFromFile(args[0]);
        BigDecimal sum = service.sumAmounts(transferList);

        System.out.println(sum);

    }

}
