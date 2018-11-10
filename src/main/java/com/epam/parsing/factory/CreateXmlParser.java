package com.epam.parsing.factory;

import com.epam.parsing.parser.DomParser;
import com.epam.parsing.parser.JaxbParser;
import com.epam.parsing.parser.SaxParser;
import com.epam.parsing.parser.Parser;

public class CreateXmlParser {

    private ParserList parserList;

    public Parser createDeposits(String typeOfParser) {
        ParserList parserName = ParserList.valueOf(typeOfParser.toUpperCase());
        switch (parserName) {
            case SAX:
                return new SaxParser();
            case DOM:
                return new DomParser();
            case JAXB:
                return new JaxbParser();
            default:
                throw new EnumConstantNotPresentException(
                         parserName.getDeclaringClass(), parserName.name());
        }
    }
}
