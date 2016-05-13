package com.hatib.resources.skipevennumbers;

import com.hatib.resources.PrimeCalculator;

import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SkipEvenNumbersPrimeCalculator implements PrimeCalculator{

    private final SkipEvenNumbersPrimeChecker skipEvenNumbersPrimeChecker;


    public SkipEvenNumbersPrimeCalculator(final SkipEvenNumbersPrimeChecker skipEvenNumbersPrimeChecker) {
        this.skipEvenNumbersPrimeChecker = skipEvenNumbersPrimeChecker;
    }

    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        return LongStream.iterate(2, n -> n + 1).filter(n -> skipEvenNumbersPrimeChecker.isPrime(n)).limit(primeNumberPosition).max().getAsLong();
    }
}
