package main.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NumberFinderTest {

    private NumberFinder numberFinder = new NumberFinder();

    @ParameterizedTest
    @CsvSource(value = {

            "123456, false",
            "145856, false",
            "111111, false",
            "121212, false",
            "142857, true",
    })
    void isWonderlandNumberTest(long number, boolean expected) {
        boolean actual = numberFinder.isWonderlandNumber(number);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void findWonderlandNumberTest() {
        long actual = numberFinder.findWonderlandNumber();
        long expected = 142857L;

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {

            "1, 1, 1",
            "2, 2, 4",
            "3, 3, 9",
    })
    void multiplyTest(long numberOne, long numberTwo, long expected) {
        long actual = numberFinder.multiply(numberOne, numberTwo);

        assertEquals(expected, actual);
    }
}
