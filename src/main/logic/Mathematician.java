package main.logic;

import java.util.List;
import java.util.stream.LongStream;

public class Mathematician {

    private QualityManager qualityManager = new QualityManager();
    private NumberReader reader = new NumberReader();

    public Long findWonderlandNumber() {
        long start = reader.rangeFrom();
        long end = reader.rangeTo();
        return LongStream.rangeClosed(start, end)
                .boxed()
                .filter(number -> isWonderlandNumber(number))
                .findFirst()
                .orElseThrow(()-> new NullPointerException("The wonderland number was not found."));
    }

    public boolean isWonderlandNumber(long number) {
        List<Long> multipliers = reader.getMultipliers();
        for (long multiplier : multipliers) {
            long multiplication = multiply(number, multiplier);
            if (!qualityManager.hasSameDigits(number, multiplication)) {
                return false;
            }
        }
        return true;
    }

    public long multiply(long firstNumber, long secondNumber) {
        return firstNumber * secondNumber;
    }
}
