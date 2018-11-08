package com.epam.parsing.parser;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.DepositEnum;
import com.epam.parsing.entity.SavingDeposit;
import com.epam.parsing.entity.TimeDeposit;
import com.epam.parsing.exception.ParserException;
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
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private DocumentBuilder documentBuilder;
    private DepositEnum depositEnum;

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
            NodeList depositsList = root.getElementsByTagName("timeDeposit");
            for (int i = 0; i < depositsList.getLength(); i++) {
                Element depositElement = (Element) depositsList.item(i);
                Deposit deposit = buildTimeDeposit(depositElement);
                deposits.add(deposit);
            }
            depositsList = root.getElementsByTagName("savingDeposit");
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
        String nameOfBank = getElementTextContent(depositElement, "nameOfBank");
        deposit.setNameOfBank(nameOfBank);

        String country = getElementTextContent(depositElement, "country");
        deposit.setCountry(country);

        double profitability = Double.parseDouble(getElementTextContent(depositElement, "profitability"));
        deposit.setProfitability(profitability);

        int timeConstraints = Integer.parseInt(getElementTextContent(depositElement, "timeConstraints"));
        deposit.setTimeConstraints(timeConstraints);

        String currencyType = getElementTextContent(depositElement, "currencyType");
        deposit.setCurrencyType(currencyType);
    }

    private Deposit buildTimeDeposit(Element depositElement) {
        TimeDeposit deposit = new TimeDeposit();
        buildDeposit(depositElement, deposit);

        double minimumSum = Double.parseDouble(getElementTextContent(depositElement, "minimumSum"));
        deposit.setMinimumSum(minimumSum);

        boolean onlineOpening = Boolean.parseBoolean(getElementTextContent(depositElement, "onlineOpening"));
        deposit.setOnlineOpening(onlineOpening);

        return deposit;
    }

    private Deposit buildSavingDeposit(Element depositElement) {
        SavingDeposit deposit = new SavingDeposit();
        buildDeposit(depositElement, deposit);

        double capitalization = Double.parseDouble(getElementTextContent(depositElement, "capitalization"));
        deposit.setCapitalization(capitalization);

        boolean cashOut = Boolean.parseBoolean(getElementTextContent(depositElement, "cashOut"));
        deposit.setCashOut(cashOut);

        return deposit;
    }
}
