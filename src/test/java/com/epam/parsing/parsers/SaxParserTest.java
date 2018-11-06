package com.epam.parsing.parsers;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.TimeDeposit;
import com.epam.parsing.exception.ParserException;
import com.epam.parsing.parser.DepositsSaxBuilder;
import com.epam.parsing.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SaxParserTest {

    private static final String PATH = "src/test/resources/banks.xml";
    private static final double DELTA = 0.001;
    private Parser parser;

    @BeforeClass
    public void setUp() {
        parser = new DepositsSaxBuilder();
    }

    @Test
    public void parserPositiveTest() throws ParserException {

        List<Deposit> depositList = parser.parser(PATH);
        TimeDeposit timeDeposit = (TimeDeposit) depositList.get(0);

        Assert.assertEquals(timeDeposit.getClass(), TimeDeposit.class);
        Assert.assertEquals(timeDeposit.getNameOfBank(), "Alfa");
        Assert.assertEquals(timeDeposit.getCountry(), "Belarus");
        Assert.assertEquals(timeDeposit.getTimeConstraints(), 30.0, DELTA);
        Assert.assertEquals(timeDeposit.getProfitability(), 25.0, DELTA);
        Assert.assertEquals(timeDeposit.getCurrencyType(), "USD");
        Assert.assertEquals(timeDeposit.getMinimumSum(), 3.0, DELTA);
        Assert.assertTrue(timeDeposit.isOnlineOpening());
    }
}
