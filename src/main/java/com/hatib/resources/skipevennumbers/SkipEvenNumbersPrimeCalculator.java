package com.hatib.resources.skipevennumbers;

import com.hatib.resources.PrimeCalculator;

import java.util.stream.LongStream;

import static com.hatib.resources.Constants.FIRST_PRIME;

/**
 * Created by Hatib on 11/05/2016.
 *
 * iterates through sequence of numbers filtering out prime numbers, with isPrime until the nth prime number is reached.
 *
 * isPrime check uses SkipEvenPrimeChecker which checks if number is prime by checking for divisors, from 1 to the square root of the number, but skipping all even numbers
 *
 */
public class SkipEvenNumbersPrimeCalculator implements PrimeCalculator{

    private final SkipEvenNumbersPrimeChecker skipEvenNumbersPrimeChecker;


    public SkipEvenNumbersPrimeCalculator(final SkipEvenNumbersPrimeChecker skipEvenNumbersPrimeChecker) {
        this.skipEvenNumbersPrimeChecker = skipEvenNumbersPrimeChecker;
    }

    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        return LongStream.iterate(FIRST_PRIME, n -> n + 1).filter(n -> skipEvenNumbersPrimeChecker.isPrime(n)).limit(primeNumberPosition).max().getAsLong();
    }
}
