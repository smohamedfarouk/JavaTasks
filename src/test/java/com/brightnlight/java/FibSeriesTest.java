package com.brightnlight.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by moham on 27/02/2016.
 */
public class FibSeriesTest {


    public FibSeriesTest() {
    }

    private FibSeries fibSeries;

    @Before
    public void setUp() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateReplaceFailWhenNoArgumentsPassed() {
        String[] args = {"AS"};
        String expectedMessage = "Invalid: Pass a number";
        try {
            //Run exception throwing operation here
            fibSeries = new FibSeries();
            fibSeries.generateWithIterativeMethod(1);

        } catch (IllegalArgumentException re) {
            Assert.assertEquals(expectedMessage, re.getMessage());
            throw re;
        }
        Assert.fail("Did not throw expected message!");
    }


    @Test
    public void validateReplacePass() {
        String[] args = {"10"};
        String expectedMessage = "";
        fibSeries.fibRecursive(10);
  //      Assert.assertTrue(actualMessage.length == 9);
    }

}
