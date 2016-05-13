package com.hatib.resources.squareroot;

import com.hatib.resources.PrimeCalculator;
import jersey.repackaged.com.google.common.cache.LoadingCache;

import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SquareRootPrimeCalculator implements PrimeCalculator{

    private final SquareRootPrimeChecker squareRootPrimeChecker;
    private LoadingCache<Integer, Long> cache;

    public SquareRootPrimeCalculator(final SquareRootPrimeChecker squareRootPrimeChecker) {
        this.squareRootPrimeChecker = squareRootPrimeChecker;
     }

    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        return LongStream.iterate(2, n -> n + 1).filter(n -> squareRootPrimeChecker.isPrime(n)).limit(primeNumberPosition).max().getAsLong();
    }
}
