package com.epam.parsing.validator;

import com.epam.parsing.handler.DepositsErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String XSD_PATH = "src/main/resources/schema.xsd";

    public boolean isValid(String path) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSD_PATH));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(path);
            validator.validate(source);
            return true;
        } catch (SAXException e) {
            LOGGER.error("Validation " + path + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error(path + " is not valid because " + e.getMessage());
        }
        return false;
    }
}
