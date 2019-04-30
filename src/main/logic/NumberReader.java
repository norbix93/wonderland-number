package main.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberReader {

    private FileReader reader = new FileReader();

    protected List<Long> getMultipliers() {
        return readColumn(0)
                .collect(Collectors.toList());
    }

    protected long rangeFrom() {
        return readColumn(1)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No Range-start found."));
    }

    protected long rangeTo() {
        return readColumn(2)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("No Range-end found."));
    }

    protected Stream<Long> readColumn(int number) {
        return reader.asStream("main/resources/data.csv")
                .skip(1)
                .map(line -> line.split(";"))
                .map(column -> Long.valueOf(column[number]));
    }
}
