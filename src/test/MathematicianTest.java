package test;

import main.logic.Mathematician;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MathematicianTest {

    private Mathematician mathematician = new Mathematician();

    @ParameterizedTest
    @CsvSource(value = {

            "123456, false",
            "145856, false",
            "111111, false",
            "121212, false",
            "142857, true",
    })
    void isWonderlandNumberTest(Long number, boolean expected) {
        boolean actual = mathematician.isWonderlandNumber(number);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void findWonderlandNumberTest() {
        long actual = mathematician.findWonderlandNumber();
        long expected = 142857L;

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
