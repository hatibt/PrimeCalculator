package com.hatib.resources.sieve;

import com.hatib.resources.PrimeCalculator;

import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SievePrimeCalculator implements PrimeCalculator {


    public Long getNthPrimeNumber(final int primeNumberPosition) {
        if (primeNumberPosition < 1) throw new IllegalArgumentException("Number must be positive");
        if (primeNumberPosition == 1) return 2l;
        Long limit = (long)(primeNumberPosition*(Math.log(primeNumberPosition) + Math.log(Math.log(primeNumberPosition)))) + 5;
        long[] array = LongStream.rangeClosed(2, limit).toArray();
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


class ClosedLong {
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

    void multipleByTwo() {
        this.number = number + number;
    }
}