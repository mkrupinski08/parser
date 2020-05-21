package org.parser.reader;

import lombok.extern.java.Log;
import org.parser.model.Transfer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Log
public class TransferReader {

    private static final String REGEX = "@";

    public List<Transfer> readTransferListFromFile(String path) {
        List<Transfer> transferList = new ArrayList<>();
        try {
            transferList = Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split(REGEX))
                    .map(this::createTransfer)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(String.format("Couldn't read file %s", e.getMessage()));
        }
        return transferList;
    }

    private String parseLine(String line) {
        return line.split(":")[1];
    }

    private Transfer createTransfer(String[] line) {
        return Transfer.builder()
                .name(parseLine(line[1]))
                .surname(parseLine(line[2]))
                .sourceIban(parseLine(line[3]))
                .destinationIban(parseLine(line[4]))
                .amount(parseLine(line[5]))
                .build();
    }

}
