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


public class DepositsSaxBuilder implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<Deposit> buildListDeposits(String path) {
        DepositHandler depositHandler = new DepositHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(depositHandler);
            reader.parse(path);
        } catch (IOException ex) {
            LOGGER.error("File error or I/O error: " + ex.getMessage(), ex);
        } catch (SAXException ex) {
            LOGGER.error("Parsing failure: " + ex.getMessage(), ex);
        }
        return depositHandler.getDeposits();
    }

    public List<Deposit> parser(String path) {
        return buildListDeposits(path);
    }
}
