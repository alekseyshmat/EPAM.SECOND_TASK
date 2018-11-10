package com.epam.parsing.handler;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.DepositEnum;
import com.epam.parsing.entity.SavingDeposit;
import com.epam.parsing.entity.TimeDeposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class DepositHandler extends DefaultHandler {

    private static final Logger LOGGER = LogManager.getLogger();
    private List<Deposit> deposits;
    private Deposit currentDeposit;
    private DepositEnum currentEnum;
    private EnumSet<DepositEnum> withText;

    public DepositHandler() {
        deposits = new ArrayList<>();
        withText = EnumSet.range(DepositEnum.NAMEOFBANK, DepositEnum.MINIMUMSUM);
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    @Override
    public void startDocument() {
        LOGGER.info("Parsing started");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("TimeDeposit")) {
            LOGGER.info("Choose time deposit");
            currentDeposit = new TimeDeposit();
        } else if (qName.equalsIgnoreCase("SavingDeposit")) {
            LOGGER.info("Choose saving deposit");
            currentDeposit = new SavingDeposit();
        } else {
            DepositEnum temp = DepositEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("TimeDeposit") || qName.equalsIgnoreCase("SavingDeposit")) {
            deposits.add(currentDeposit);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String characters = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAMEOFBANK:
                    currentDeposit.setNameOfBank(characters);
                    break;
                case COUNTRY:
                    currentDeposit.setCountry(characters);
                    break;
                case PROFITABILITY:
                    double profitability = Double.parseDouble(characters);
                    currentDeposit.setProfitability(profitability);
                    break;
                case TIMECONSTRAINTS:
                    int timeConstraints = Integer.parseInt(characters);
                    currentDeposit.setTimeConstraints(timeConstraints);
                    break;
                case CURRENCYTYPE:
                    currentDeposit.setCurrencyType(characters);
                    break;
                case CAPITALIZATION:
                    double capitalization = Double.parseDouble(characters);
                    ((SavingDeposit) currentDeposit).setCapitalization(capitalization);
                    break;
                case CASHOUT:
                    boolean cashOut = Boolean.parseBoolean(characters);
                    ((SavingDeposit) currentDeposit).setCashOut(cashOut);
                    break;
                case MINIMUMSUM:
                    double minimumSum = Double.parseDouble(characters);
                    ((TimeDeposit) currentDeposit).setMinimumSum(minimumSum);
                    break;
                case ONLINEOPENING:
                    boolean onlineOpening = Boolean.parseBoolean(characters);
                    ((TimeDeposit) currentDeposit).setOnlineOpening(onlineOpening);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

    @Override
    public void endDocument() {
        LOGGER.info("Parsing ended");
    }

}
