package com.brightnlight.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by moham on 27/02/2016.
 */
public class FibSeriesTest {
    public FibSeriesTest() {
    }



/*
    @Test(expected = InvalidInputException.class)
    public void validateReplaceFailWhenNoArgumentsPassed() throws InvalidInputException {
        String[] args = {"AS"};
        String expectedMessage = "Invalid: Pass a number";
        try {
            //Run exception throwing operation here
            FibSeries fibSeries = new FibSeries();
            fibSeries.generateWithIterativeMethod(12);
        } catch (InvalidInputException re) {
            Assert.assertEquals(expectedMessage, re.getMessage());
            throw re;
        }
       // Assert.fail("Did not throw InvalidInputException message!");
    }*/

    @Test
    public void validateIterativePass() throws InvalidInputException {
        FibSeries fibSeries = new FibSeries();
        BigInteger value =fibSeries.fibIterative( BigInteger.valueOf(10));
        Assert.assertTrue(value.equals(BigInteger.valueOf(55)));
    }

    @Test
    public void validateIterPass() throws InvalidInputException {
        FibSeries fibSeries = new FibSeries();
        BigInteger value = fibSeries.fibIter( BigInteger.valueOf(10));
        Assert.assertTrue(value.equals(BigInteger.valueOf(55)));
    }
    @Test
    public void validateRecursivePass() {
        FibSeries fibSeries = new FibSeries();
        BigInteger value =fibSeries.fibRecursive( BigInteger.valueOf(10));
        Assert.assertTrue(value.equals(BigInteger.valueOf(55)));

    }
    @Test
    public void validateTailRecursivePass() {
        FibSeries fibSeries = new FibSeries();
        BigInteger value =fibSeries.fibTailRecursive( BigInteger.valueOf(10), BigInteger.valueOf(1), BigInteger.valueOf(0));
        Assert.assertTrue(value.equals(BigInteger.valueOf(55)));

    }
    @Test
    public void validateImprovedFibPass() {
        FibSeries fibSeries = new FibSeries();
        BigInteger value =fibSeries.improvedFibo(BigInteger.valueOf(10));
        Assert.assertTrue(value.equals(BigInteger.valueOf(55)));
    }
}
