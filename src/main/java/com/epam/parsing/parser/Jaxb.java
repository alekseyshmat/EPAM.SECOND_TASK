package com.epam.parsing.parser;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.Deposits;
import com.epam.parsing.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Jaxb implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<Deposit> parser(String path) throws ParserException {
        File file = new File("banks.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Deposits.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Deposits deposits = (Deposits) jaxbUnmarshaller.unmarshal(file);
            return deposits.getListOfDeposits();
        } catch (JAXBException e) {
            throw new ParserException(e.getMessage(), e);
        }
    }
}
