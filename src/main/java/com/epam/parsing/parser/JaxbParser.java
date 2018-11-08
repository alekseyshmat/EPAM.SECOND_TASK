package com.epam.parsing.parser;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.Deposits;
import com.epam.parsing.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String XSD_PATH = "src/main/resources/schema.xsd";

    public List<Deposit> parser(String path) throws ParserException {
        List<Deposit> resultTariffs = null;
        Deposits deposits = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Deposits.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = schemaFactory.newSchema(new File(XSD_PATH));
//            jaxbUnmarshaller.setSchema(schema);
            deposits = (Deposits) jaxbUnmarshaller.unmarshal(new File(path));

            System.out.println(deposits);
           return deposits.getListOfDeposits();
//            resultTariffs = makeTariffList(deposits);
        } catch (JAXBException e) {
            throw new ParserException(e.getMessage(), e);
//        } catch (SAXException e) {
//            e.printStackTrace();
        }
//        return resultTariffs;

//        return deposit.getListOfDeposits();
    }

    private List<Deposit> makeTariffList(Deposits deposits) {
        List<Deposit> resultTariffsList = new ArrayList<Deposit>();
        for (JAXBElement element : deposits.getDeposit()) {
            resultTariffsList.add((Deposit) element.getValue());
        }
        return resultTariffsList;
    }

}
