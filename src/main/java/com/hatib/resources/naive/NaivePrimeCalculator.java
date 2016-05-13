package com.hatib.resources.naive;

import com.hatib.resources.PrimeCalculator;

import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 *
 * iterates through sequence of numbers filtering out prime numbers, with isPrime until the nth prime number is reached.
 *
 * isPrime check uses NaivePrimeChecker which checks if number is prime by checking for divisors, from 1 to half the numbers size

 *
 */
public class NaivePrimeCalculator  implements PrimeCalculator {

    private final NaivePrimeChecker naivePrimeChecker;


    public NaivePrimeCalculator(final NaivePrimeChecker naivePrimeChecker){
        this.naivePrimeChecker = naivePrimeChecker;
    }

    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        return LongStream.iterate(2, n -> n + 1).filter(n -> naivePrimeChecker.isPrime(n)).limit(primeNumberPosition).max().getAsLong();
    }
}
