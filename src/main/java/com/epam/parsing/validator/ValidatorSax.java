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
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = factory.newSchema(new File(XSD_PATH));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(path);
            DepositsErrorHandler dh = new DepositsErrorHandler();
            validator.setErrorHandler(dh);
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
