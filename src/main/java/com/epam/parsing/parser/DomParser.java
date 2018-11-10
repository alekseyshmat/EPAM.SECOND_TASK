package com.epam.parsing.parser;

import com.epam.parsing.entity.CountryEnum;
import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.SavingDeposit;
import com.epam.parsing.entity.TimeDeposit;
import com.epam.parsing.exception.ParserException;
import javafx.util.converter.BigDecimalStringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String TIME_DEPOSIT = "timeDeposit";
    private static final String SAVING_DEPOSIT = "savingDeposit";
    private static final String NAME_OF_BANK = "nameOfBank";
    private static final String COUNTRY = "country";
    private static final String PROFITABILITY = "profitability";
    private static final String TIME_CONSTRAINTS = "timeConstraints";
    private static final String CURRENCY_TYPE = "currencyType";
    private static final String MINIMUM_SUM = "minimumSum";
    private static final String ONLINE_OPENING = "onlineOpening";
    private static final String CAPITALIZATION = "capitalization";
    private static final String CASH_OUT = "cashOut";


    private DocumentBuilder documentBuilder;

    public List<Deposit> parser(String path) {
        return buildListDeposits(path);
    }

    public List<Deposit> buildListDeposits(String path) {
        List<Deposit> deposits = new ArrayList<Deposit>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage(), e);
        }
        try {
            if (documentBuilder == null) {
                throw new ParserException("File is empty");
            }
            Document document = documentBuilder.parse(path);

            Element root = document.getDocumentElement();
            NodeList depositsList = root.getElementsByTagName(TIME_DEPOSIT);
            for (int i = 0; i < depositsList.getLength(); i++) {
                Element depositElement = (Element) depositsList.item(i);
                Deposit deposit = buildTimeDeposit(depositElement);
                deposits.add(deposit);
            }
            depositsList = root.getElementsByTagName(SAVING_DEPOSIT);
            for (int i = 0; i < depositsList.getLength(); i++) {
                Element depositElement = (Element) depositsList.item(i);
                Deposit deposit = buildSavingDeposit(depositElement);
                deposits.add(deposit);
            }
        } catch (IOException ex) {
            LOGGER.error("File error or I/O error: " + ex.getMessage(), ex);
        } catch (SAXException e) {
            LOGGER.error("Parsing fail: " + e.getMessage(), e);
        } catch (ParserException e) {
            LOGGER.error("Parsing failure: " + e.getMessage(), e);
        }
        return deposits;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private void buildDeposit(Element depositElement, Deposit deposit) {
        String nameOfBank = getElementTextContent(depositElement, NAME_OF_BANK);
        deposit.setNameOfBank(nameOfBank);

        String country = getElementTextContent(depositElement, COUNTRY);
        deposit.setCountry(CountryEnum.fromValue(country));

        double profitability = Double.parseDouble(getElementTextContent(depositElement, PROFITABILITY));
        deposit.setProfitability(profitability);

        int timeConstraints = Integer.parseInt(getElementTextContent(depositElement, TIME_CONSTRAINTS));
        deposit.setTimeConstraints(timeConstraints);

        String currencyType = getElementTextContent(depositElement, CURRENCY_TYPE);
        deposit.setCurrencyType(currencyType);
    }

    private Deposit buildTimeDeposit(Element depositElement) {
        TimeDeposit deposit = new TimeDeposit();
        buildDeposit(depositElement, deposit);

        double minimumSum = Double.parseDouble(getElementTextContent(depositElement, MINIMUM_SUM));
        deposit.setMinimumSum(minimumSum);

        boolean onlineOpening = Boolean.parseBoolean(getElementTextContent(depositElement, ONLINE_OPENING));
        deposit.setOnlineOpening(onlineOpening);

        return deposit;
    }

    private Deposit buildSavingDeposit(Element depositElement) {
        SavingDeposit deposit = new SavingDeposit();
        buildDeposit(depositElement, deposit);

        double capitalization = Double.parseDouble(getElementTextContent(depositElement, CAPITALIZATION));
        deposit.setCapitalization(capitalization);

        boolean cashOut = Boolean.parseBoolean(getElementTextContent(depositElement, CASH_OUT));
        deposit.setCashOut(cashOut);

        return deposit;
    }
}
