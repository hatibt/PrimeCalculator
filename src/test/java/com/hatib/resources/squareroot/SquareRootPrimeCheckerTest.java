package com.hatib.resources.squareroot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hatib on 11/05/2016.
 */
public class SquareRootPrimeCheckerTest {

    @org.junit.Test
    public void minusFourIsNotAPrime() throws Exception {
        assertFalse(new SquareRootPrimeChecker().isPrime(-4l));
    }

    @org.junit.Test
    public void oneIsNotAPrime() throws Exception {
        assertFalse(new SquareRootPrimeChecker().isPrime(1l));
    }

    @org.junit.Test
    public void twoIsAPrime() throws Exception {
        assertTrue(new SquareRootPrimeChecker().isPrime(2l));
    }

    @org.junit.Test
    public void threeIsAPrime() throws Exception {
        assertTrue(new SquareRootPrimeChecker().isPrime(3l));
    }

    @org.junit.Test
    public void fourIsNotAPrime() throws Exception {
        assertFalse(new SquareRootPrimeChecker().isPrime(4l));
    }

    @org.junit.Test
    public void sevenIsAPrime() throws Exception {
        assertTrue(new SquareRootPrimeChecker().isPrime(7l));
    }

    @org.junit.Test
    public void seventeenIsAPrime() throws Exception {
        assertTrue(new SquareRootPrimeChecker().isPrime(17l));
    }

    @org.junit.Test
    public void tenThousandAndSevenIsAPrime() throws Exception {
        assertTrue(new SquareRootPrimeChecker().isPrime(10007l));
    }
}