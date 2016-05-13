package com.hatib.resources.skipevennumbers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SkipEvenNumbersPrimeCheckerTest {

    @org.junit.Test
    public void minusFourIsNotAPrime() throws Exception {
        assertFalse(new SkipEvenNumbersPrimeChecker().isPrime(-4l));
    }

    @org.junit.Test
    public void oneIsNotAPrime() throws Exception {
        assertFalse(new SkipEvenNumbersPrimeChecker().isPrime(1l));
    }

    @org.junit.Test
    public void twoIsAPrime() throws Exception {
        assertTrue(new SkipEvenNumbersPrimeChecker().isPrime(2l));
    }

    @org.junit.Test
    public void threeIsAPrime() throws Exception {
        assertTrue(new SkipEvenNumbersPrimeChecker().isPrime(3l));
    }

    @org.junit.Test
    public void fourIsNotAPrime() throws Exception {
        assertFalse(new SkipEvenNumbersPrimeChecker().isPrime(4l));
    }

    @org.junit.Test
    public void sevenIsAPrime() throws Exception {
        assertTrue(new SkipEvenNumbersPrimeChecker().isPrime(7l));
    }

    @org.junit.Test
    public void seventeenIsAPrime() throws Exception {
        assertTrue(new SkipEvenNumbersPrimeChecker().isPrime(17l));
    }

    @org.junit.Test
    public void tenThousandAndSevenIsAPrime() throws Exception {
        assertTrue(new SkipEvenNumbersPrimeChecker().isPrime(10007l));
    }
}