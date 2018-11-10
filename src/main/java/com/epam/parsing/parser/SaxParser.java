package com.epam.parsing.parser;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.handler.DepositHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    private List<Deposit> buildListDeposits(String path) {
        DepositHandler depositHandler = new DepositHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(depositHandler);
            reader.parse(path);
        } catch (IOException e) {
            LOGGER.error("File error: " + e.getMessage(), e);
        } catch (SAXException e) {
            LOGGER.error("Parsing failure: " + e.getMessage(), e);
        }
        return depositHandler.getDeposits();
    }

    public List<Deposit> parser(String path) {
        return buildListDeposits(path);
    }
}
