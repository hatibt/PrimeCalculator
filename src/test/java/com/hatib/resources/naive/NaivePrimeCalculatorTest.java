package com.hatib.resources.naive;

import static org.junit.Assert.assertTrue;

/**
 * Created by Hatib on 11/05/2016.
 */
public class NaivePrimeCalculatorTest {


    @org.junit.Test(expected = IllegalArgumentException.class)
    public void canOnlySearchForOneOrMorePrimeNumbers() throws Exception {
        new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(-1);
    }

    @org.junit.Test
    public void firstPrimeNumberEqualsTwo() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(1)== 2);
    }

    @org.junit.Test
    public void secondPrimeNumberEqualsThree() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(2)== 3);
    }

    @org.junit.Test
    public void thirdPrimeNumberEqualsFive() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(3)== 5);
    }

    @org.junit.Test
    public void fourthPrimeNumberEqualsSeven() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(4)== 7);
    }

    @org.junit.Test
    public void fifthPrimeNumberEqualsEleven() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(5)==11);
    }

    @org.junit.Test
    public void sixthPrimeNumberEqualsThirteen() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(6)== 13);
    }

    @org.junit.Test
    public void seventhPrimeNumberEqualsSeventeen() throws Exception {
        assertTrue(new NaivePrimeCalculator(new NaivePrimeChecker()).getNthPrimeNumber(7)== 17);
    }



}