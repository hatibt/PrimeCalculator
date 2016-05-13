package com.hatib.resources.squareroot;

import com.hatib.resources.SkipEvenNumbersPPrimeChecker;

import java.util.concurrent.ExecutionException;
import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SquareRootPrimeChecker implements SkipEvenNumbersPPrimeChecker {

    public boolean isPrime(long number) {
        if (number < 2) return false;
        try {
            return !numberHasDivisors(number);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean numberHasDivisors(long number) throws ExecutionException, InterruptedException {
        return LongStream.rangeClosed(2, (long) Math.sqrt(number)).parallel().filter(no -> number % no == 0).findAny().isPresent();
    }
}
