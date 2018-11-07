package com.epam.parsing.factory;

import com.epam.parsing.parser.DomParser;
import com.epam.parsing.parser.JaxbParser;
import com.epam.parsing.parser.SaxParser;
import com.epam.parsing.parser.Parser;

public class CreateXmlParser {

    private ParserList parserList;

    public Parser createDeposits(String parser) {
        ParserList parserName = ParserList.valueOf(parser.toUpperCase());
        switch (parserName) {
            case SAXPARSER:
                return new SaxParser();
            case DOMPARSER:
                return new DomParser();
            case JAXBPARSER:
                return new JaxbParser();
            default:
                throw new EnumConstantNotPresentException(
                        parserName.getDeclaringClass(), parserName.name());
        }
    }
}
