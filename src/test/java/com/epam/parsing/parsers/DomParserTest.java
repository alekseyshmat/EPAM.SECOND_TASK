package com.epam.parsing.parsers;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.SavingDeposit;
import com.epam.parsing.entity.TimeDeposit;
import com.epam.parsing.exception.ParserException;
import com.epam.parsing.parser.DomParser;
import com.epam.parsing.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DomParserTest {

    private static final String PATH = "src/test/resources/deposits.xml";
    private static final double DELTA = 0.001;
    private Parser parser;

    @BeforeClass
    public void setUp(){
        parser = new DomParser();
    }

    @Test
    public void domParserPositiveTest() throws ParserException {

        List<Deposit> depositList = parser.parser(PATH);
        TimeDeposit timeDeposit = (TimeDeposit) depositList.get(1);

        Assert.assertEquals(timeDeposit.getBankId(), "BYBEL422");
        Assert.assertEquals(timeDeposit.getNameOfBank(), "Belarusbank");
        Assert.assertEquals(timeDeposit.getCountry().value(), "Belarus");
        Assert.assertEquals(timeDeposit.getProfitability(), 9.5, DELTA);
        Assert.assertEquals(timeDeposit.getTimeConstraints(), 65);
        Assert.assertEquals(timeDeposit.getCurrencyType(), "BYN");
        Assert.assertEquals(timeDeposit.getMinimumSum(), 500.0);
        Assert.assertFalse(timeDeposit.isOnlineOpening());
    }
}
