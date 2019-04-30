package main.logic;

import java.util.Arrays;

public class QualityManager {

    protected boolean hasSameDigits(long inputNumberOne, long inputNumberTwo) {
        char[] numberOne = sortDigits(inputNumberOne);
        char[] numberTwo = sortDigits(inputNumberTwo);
        return (Arrays.equals(numberOne, numberTwo));
    }

    protected char[] sortDigits(long input) {
        String asString = String.valueOf(input);
        char[] asCharArray = asString.toCharArray();
        Arrays.sort(asCharArray);
        return asCharArray;
    }
}

