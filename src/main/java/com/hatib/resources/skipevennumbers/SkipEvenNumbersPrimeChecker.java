package com.hatib.resources.skipevennumbers;

import com.hatib.resources.SkipEvenNumbersPPrimeChecker;

import java.util.concurrent.ExecutionException;
import java.util.stream.LongStream;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SkipEvenNumbersPrimeChecker implements SkipEvenNumbersPPrimeChecker {

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
        if(number == 2) return false;
        if(number % 2 == 0) return true;
        long sqrt = (long) Math.sqrt(number);
        return LongStream.iterate(3, n ->  (n + 2)).limit(sqrt).parallel().filter(n -> (n <= sqrt) && (number % n == 0)).findAny().isPresent();
    }
}
