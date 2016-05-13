package com.hatib.resources.sieve;

import com.hatib.resources.PrimeCalculator;

import java.util.Arrays;
import java.util.stream.LongStream;

import static com.hatib.resources.Constants.FIRST_PRIME;

/**
 * Created by Hatib on 13/05/2016.
 *
 * Sieve of Eratosthenes.sieve,  first estimates number close to desired prime then seives out prime numbers in a sequence starting from 2
 *
 * Uses ClosedLong to get around Java's requirement for variables to be final
 *
 */
public class SievePrimeCalculator implements PrimeCalculator {

    public static final int PRIME_ESTIMATOR_CONSTANT = 3;

    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        if (primeNumberPosition == 1) return FIRST_PRIME;

        Long limit = (long)(primeNumberPosition*(Math.log(primeNumberPosition) + Math.log(Math.log(primeNumberPosition)))) + PRIME_ESTIMATOR_CONSTANT;
        long[] array = LongStream.rangeClosed(FIRST_PRIME, limit).toArray();
        final ClosedLong closedLong = new ClosedLong(array[0]);

        int index = 0;
        while(index < array.length - 1) {
            array = Arrays.stream(array).parallel().filter(n -> (n == closedLong.getNumber()) || (n % closedLong.getNumber()) > 0).toArray();
            index = index + 1;
            closedLong.setNumber(array[index]);
        }
        return array[primeNumberPosition-1];
    }
}


final class ClosedLong {
    private long number;

    ClosedLong(long number) {
        this.number = number;
    }

    long getNumber() {
        return number;
    }

    void setNumber(long number) {
        this.number = number;
    }

}