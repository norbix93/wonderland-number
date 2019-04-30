package main.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberReader {

    private FileReader reader = new FileReader();

    public List<Long> getMultipliers() {
        return readColumn(0)
                .collect(Collectors.toList());
    }

    public long rangeFrom() {
        return readColumn(1)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No Range-start found."));
    }

    public long rangeTo() {
        return readColumn(2)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No Range-end found."));
    }

    public Stream<Long> readColumn(int number) {
        return reader.asStream("main/resources/data.csv")
                .skip(1)
                .map(line -> line.split(";"))
                .map(column -> Long.valueOf(column[number]));
    }
}
