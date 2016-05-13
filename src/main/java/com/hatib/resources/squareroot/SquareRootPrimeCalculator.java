package com.hatib.resources.squareroot;

import com.hatib.resources.PrimeCalculator;
import jersey.repackaged.com.google.common.cache.LoadingCache;

import java.util.stream.LongStream;

import static com.hatib.resources.Constants.FIRST_PRIME;

/**
 * Created by Hatib on 11/05/2016.
 * *
 * iterates through sequence of numbers filtering out prime numbers, with isPrime until the nth prime number is reached
 *
 *  isPrime check uses SquareRootPrimeChecker to check if number is prime, by checking for divisors, from 1 to the square root of the number
 *
 */
public class SquareRootPrimeCalculator implements PrimeCalculator{

    private final SquareRootPrimeChecker squareRootPrimeChecker;
    private LoadingCache<Integer, Long> cache;

    public SquareRootPrimeCalculator(final SquareRootPrimeChecker squareRootPrimeChecker) {
        this.squareRootPrimeChecker = squareRootPrimeChecker;
     }

    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        return LongStream.iterate(FIRST_PRIME, n -> n + 1).filter(n -> squareRootPrimeChecker.isPrime(n)).limit(primeNumberPosition).max().getAsLong();
    }
}
