package com.epam.parsing.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class DepositsErrorHandler extends DefaultHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    public DepositsErrorHandler() {
    }

    public void warning(SAXParseException e) {
        LOGGER.warn(getLineAddress(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        LOGGER.error(getLineAddress(e) + "-" + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        LOGGER.fatal(getLineAddress(e) + "-" + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
