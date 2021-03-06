package main.logic.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class NumberReaderTest {

    private NumberReader reader = new NumberReader();

    @Test
    void getMultipliersTest() {
        List<Long> actual = reader.getMultipliers();

        Assertions.assertNotNull(actual);
        Assertions.assertNotEquals(9, actual.size());
        Assertions.assertEquals(5, actual.size());
    }

    @Test
    void rangeFromTest() {
        long actual = reader.rangeFrom();
        long unexpected = 145L;
        long expected = 123456L;

        Assertions.assertNotNull(actual);
        Assertions.assertNotEquals(unexpected, actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void rangeToTest() {
        long actual = reader.rangeTo();
        long unexpected = 1456L;
        long expected = 166666L;

        Assertions.assertNotNull(actual);
        Assertions.assertNotEquals(unexpected, actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readColumnTest() {
        int actual = reader.readColumn(0)
                .collect(Collectors.toList())
                .size();
        int unexpected = 8;
        int expected = 5;

        Assertions.assertNotNull(actual);
        Assertions.assertNotEquals(unexpected, actual);
        Assertions.assertEquals(expected, actual);
    }
}
