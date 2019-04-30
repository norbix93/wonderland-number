package main.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QualityManagerTest {

    private QualityManager qualityManager = new QualityManager();

    @ParameterizedTest
    @CsvSource(value = {

            "123456, 654321, true",
            "145856, 658545, false",
            "111111, 111112, false",
            "121212, 212121, true",
            "142857, 758241, true"
    })
    void isWonderlandNumberTest(long numberOne, long numberTwo, boolean expected) {
        boolean actual = qualityManager.hasSameDigits(numberOne, numberTwo);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {

            "123456, 123456",
            "145856, 145568",
            "111111, 111111",
            "121212, 111222",
            "142857, 124578"
    })
    void sortDigitsTest(Long inputNumber, String expectedNumber) {
        char[] actual = qualityManager.sortDigits(inputNumber);
        char[] expected = expectedNumber.toCharArray();

        assertNotNull(actual);
        assertNotNull(expected);
        Assertions.assertArrayEquals(expected, actual);
    }
}
