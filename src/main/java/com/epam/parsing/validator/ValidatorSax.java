package com.epam.parsing.validator;

import com.epam.parsing.handler.DepositsErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String PATH = "src/test/resources/banks.xml";
    private static final String XSD_PATH = "src/main/resources/schema.xsd";

    public boolean isValid() {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = factory.newSchema(new File(XSD_PATH));
            SAXParserFactory saxParserFactory  =SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);
            SAXParser parser = saxParserFactory.newSAXParser();
             parser.parse(PATH, new DepositsErrorHandler());
            return true;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return false;
    }
}
