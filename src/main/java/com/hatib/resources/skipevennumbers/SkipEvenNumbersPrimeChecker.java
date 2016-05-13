package com.hatib.resources.skipevennumbers;

import com.hatib.resources.PrimeChecker;

import java.util.OptionalLong;
import java.util.concurrent.ExecutionException;
import java.util.stream.LongStream;

import static com.hatib.resources.Constants.FIRST_PRIME;

/**
 * Created by Hatib on 11/05/2016.
 *
 * Checks if number is prime by checking for divisors, from 1 to the squrae root of the number, but skipping all even numbers
 *
 */
public class SkipEvenNumbersPrimeChecker implements PrimeChecker {

    public static final int EVEN_NUMBER_DIVISOR = 2;
    public static final int SECOND_PRIME = 3;

    public boolean isPrime(long number) {
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
        if(number == FIRST_PRIME) return true;
        if(number % EVEN_NUMBER_DIVISOR == 0) return false;
        long sqrt = (long) Math.sqrt(number);
        final OptionalLong optionalLong = LongStream.iterate(SECOND_PRIME, n -> (n + 2)).limit(sqrt).parallel().filter(n -> (n <= sqrt) && (number % n == 0)).findAny();
        return !optionalLong.isPresent();
    }
}
