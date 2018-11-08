package com.epam.parsing.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidatorSaxTest {

    private static final String VALID_PATH = "src/test/resources/deposits.xml";
    private static final String INVALID_PATH = "src/test/resources/invalidFile.xml";
    private ValidatorSax validatorSax;

    @BeforeClass
    public void setUp() {
        validatorSax = new ValidatorSax();
    }

    @Test
    public void validatorSaxPositiveTest() {
        boolean actual = validatorSax.isValid(VALID_PATH);
        Assert.assertTrue(actual);
    }

    @Test
    public void validatorSaxNegativeTest() {
        boolean actual = validatorSax.isValid(INVALID_PATH);
        Assert.assertFalse(actual);
    }
}

