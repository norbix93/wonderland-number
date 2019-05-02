package main.logic;

import main.logic.reader.NumberReader;
import main.logic.verifier.DigitVerifier;

import java.util.List;
import java.util.stream.LongStream;

public class NumberFinder {

    private DigitVerifier digitVerifier = new DigitVerifier();
    private NumberReader reader = new NumberReader();

    public long findWonderlandNumber() {
        long start = reader.rangeFrom();
        long end = reader.rangeTo();
        return LongStream.rangeClosed(start, end)
                .boxed()
                .filter(number -> isWonderlandNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("The wonderland number was not found."));
    }

    boolean isWonderlandNumber(long number) {
        List<Long> multipliers = reader.getMultipliers();
        for (long multiplier : multipliers) {
            long multiplication = multiply(number, multiplier);
            if (!digitVerifier.hasSameDigits(number, multiplication)) {
                return false;
            }
        }
        return true;
    }

    long multiply(long firstNumber, long secondNumber) {
        return firstNumber * secondNumber;
    }
}
