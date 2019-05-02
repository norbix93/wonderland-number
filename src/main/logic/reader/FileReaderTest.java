package main.logic.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FileReaderTest {

    private FileReader reader = new FileReader();

    @Test
    void asStream() {
        List<String> expected = Arrays.asList("Multipliers;Range-start;Range-end;");
        List<String> actual = reader.asStream("main/resources/data.csv")
                .limit(1)
                .collect(Collectors.toList());

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(actual.size(), 1);
    }
}