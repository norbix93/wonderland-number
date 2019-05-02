package main.logic.verifier;

import java.util.Arrays;

public class DigitVerifier {

    public boolean hasSameDigits(long inputNumberOne, long inputNumberTwo) {
        char[] numberOne = sortDigits(inputNumberOne);
        char[] numberTwo = sortDigits(inputNumberTwo);
        return (Arrays.equals(numberOne, numberTwo));
    }

    char[] sortDigits(long input) {
        String asString = String.valueOf(input);
        char[] asCharArray = asString.toCharArray();
        Arrays.sort(asCharArray);
        return asCharArray;
    }
}

