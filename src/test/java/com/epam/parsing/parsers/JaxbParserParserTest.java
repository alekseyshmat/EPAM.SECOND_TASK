package com.epam.parsing.parsers;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.TimeDeposit;
import com.epam.parsing.exception.ParserException;
import com.epam.parsing.parser.JaxbParser;
import com.epam.parsing.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class JaxbParserParserTest {

    private static final String PATH = "src/test/resources/deposits.xml";
    private static final double DELTA = 0.001;
    private Parser parser;

    @BeforeClass
    public void setUp() {
        parser = new JaxbParser();
    }

    @Test
    public void jaxbParserTestPositive() {
        try {
            List<Deposit> depositList = parser.parser(PATH);
            TimeDeposit timeDeposit = (TimeDeposit) depositList.get(0);

            Assert.assertEquals(timeDeposit.getNameOfBank(), "AlfaBank");
            Assert.assertEquals(timeDeposit.getCountry().value(), "Belarus");
            Assert.assertEquals(timeDeposit.getTimeConstraints(), 30.0, DELTA);
            Assert.assertEquals(timeDeposit.getProfitability(), 25.0, DELTA);
            Assert.assertEquals(timeDeposit.getCurrencyType(), "USD");
            Assert.assertEquals(timeDeposit.getMinimumSum(), 3.0);
            Assert.assertTrue(timeDeposit.isOnlineOpening());
        } catch (ParserException e) {
            e.printStackTrace();
        }

    }
}
