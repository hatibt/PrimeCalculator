package com.hatib.resources.naive;

import com.hatib.resources.SkipEvenNumbersPPrimeChecker;

import java.util.OptionalLong;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 */
public class NaivePrimeChecker implements SkipEvenNumbersPPrimeChecker {

    public boolean isPrime(long number)  {
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
        final LongStream stream = LongStream.rangeClosed(2, number/2).parallel();
        final Callable<OptionalLong> task = () -> stream.filter(no -> number % no == 0).findAny();
        final ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        final OptionalLong optionalLong = forkJoinPool.submit(task).get();
        return optionalLong.isPresent();
    }
}
