package com.epam.parsing.parsers;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.SavingDeposit;
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
        SavingDeposit savingDeposit = (SavingDeposit) depositList.get(1);

        Assert.assertEquals(savingDeposit.getNameOfBank(), "IDEA");
        Assert.assertEquals(savingDeposit.getCountry(), "UKRAINE");
        Assert.assertEquals(savingDeposit.getProfitability(), 10.0, DELTA);
        Assert.assertEquals(savingDeposit.getTimeConstraints(), 45.0, DELTA);
        Assert.assertEquals(savingDeposit.getCurrencyType(), "GRN");
        Assert.assertEquals(savingDeposit.getCapitalization(), 10.0, DELTA);
        Assert.assertTrue(savingDeposit.isCashOut());
    }
}
