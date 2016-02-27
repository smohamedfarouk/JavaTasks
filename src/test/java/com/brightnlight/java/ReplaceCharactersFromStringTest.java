package com.brightnlight.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by moham on 27/02/2016.
 */
public class ReplaceCharactersFromStringTest {

    public ReplaceCharactersFromStringTest() {
    }

    private ReplaceCharactersFromString replaceCharactersFromString;

    @Before
    public void setUp() {
        replaceCharactersFromString = new ReplaceCharactersFromString();
    }

    @Test
    public void validateReplaceFailWhenNoArgumentsPassed() {
        String[] args = null;
        String expectedMessage = "Invalid: Number of Arguments Provided, Usage: java ReplaceCharactersFromString <String> <Single character>";
        String actualMessage = replaceCharactersFromString.replace(args);
        Assert.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage));
    }

    @Test
    public void validateReplaceFailWhenOneArgumentsPassed() {
        String[] args = {"hello"};
        String expectedMessage = "Invalid: Number of arguments provided, Usage: java ReplaceCharactersFromString <String> <Single character>";
        String actualMessage = replaceCharactersFromString.replace(args);
        Assert.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage));
    }

    @Test
    public void validateReplaceFailWhenCharactersLengthGreaterThan1() {
        String[] args = {"hello", "22"};
        String expectedMessage = "Invalid: Character to be replaced length greater than 1";
        String actualMessage = replaceCharactersFromString.replace(args);
        Assert.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage));
    }

    @Test
    public void validateReplacePass() {
        String[] args = {"hello", "a"};
        String expectedMessage = "";
        String actualMessage = replaceCharactersFromString.replace(args);
        Assert.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage));
    }

}
