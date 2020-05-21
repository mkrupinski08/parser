package org.parser.reader;

import org.parser.model.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader {

    public List<Transaction> readTransactionsFromFile(String path) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines()
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split("@"))
                    .forEach(line -> transactions.add(Transaction.builder()
                            .name(parseLine(line[1]))
                            .surname(parseLine(line[2]))
                            .srcIban(parseLine(line[3]))
                            .dstIban(parseLine(line[4]))
                            .amount(parseLine(line[5]))
                            .build()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    private String parseLine(String line) {
        return line.split(":")[1];
    }

}
