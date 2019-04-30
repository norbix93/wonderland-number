package main.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberReader {

    private FileReader reader = new FileReader();

    public List<Long> getMultipliers() {
        return readDocument()
                .map(column -> Long.valueOf(column[0]))
                .collect(Collectors.toList());
    }

    public Long rangeFrom() {
        return readDocument()
                .map(column -> Long.valueOf(column[1]))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public Long rangeTo() {
        return readDocument()
                .map(column -> Long.valueOf(column[2]))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public Stream<String[]> readDocument() {
        return reader.asStream("main/resources/data.csv")
                .skip(1)
                .map(line -> line.split(";"));
    }
}
