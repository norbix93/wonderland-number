package main.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberReader {

    private FileReader reader = new FileReader();

    public List<Long> getMultipliers() {
        return readDocument(0)
                .collect(Collectors.toList());
    }

    public long rangeFrom() {
        return readDocument(1)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No Range-start found."));
    }

    public long rangeTo() {
        return readDocument(2)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No Range-end found."));
    }

    public Stream<Long> readDocument(int columnNumber) {
        return reader.asStream("main/resources/data.csv")
                .skip(1)
                .map(line -> line.split(";"))
                .map(column -> Long.valueOf(column[columnNumber]));

    }
}
