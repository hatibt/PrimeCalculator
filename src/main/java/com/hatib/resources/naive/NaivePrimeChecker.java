package com.hatib.resources.naive;

import com.hatib.resources.PrimeChecker;

import java.util.OptionalLong;
import java.util.concurrent.ExecutionException;
import java.util.stream.LongStream;

import static com.hatib.resources.Constants.FIRST_PRIME;


/**
 * Created by Hatib on 11/05/2016.
 *
 * Checks if number is prime by checking for divisors, from 1 to half the numbers size
 */
public class NaivePrimeChecker implements PrimeChecker {

    public boolean isPrime(long number)  {
        if (number < FIRST_PRIME) return false;
        try {
            return numberHasNoDivisors(number);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean numberHasNoDivisors(long number) throws ExecutionException, InterruptedException {
        final OptionalLong optionalLong = LongStream.rangeClosed(FIRST_PRIME, number/2).parallel().filter(no -> number % no == 0).findAny();
        return !optionalLong.isPresent();
    }
}
