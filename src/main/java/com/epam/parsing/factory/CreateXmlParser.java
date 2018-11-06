package com.epam.parsing.factory;

import com.epam.parsing.parser.DepositsDomBuilder;
import com.epam.parsing.parser.DepositsSaxBuilder;
import com.epam.parsing.parser.Jaxb;
import com.epam.parsing.parser.Parser;

public class CreateXmlParser {

    private ParserList parserList;

    public Parser createDeposits(String parser) {
        ParserList parserName = ParserList.valueOf(parser.toUpperCase());
        switch (parserName) {
            case SAXPARSER:
                return new DepositsSaxBuilder();
            case DOMPARSER:
                return new DepositsDomBuilder();
            case JAXBPARSER:
                return new Jaxb();
            default:
                throw new EnumConstantNotPresentException(
                        parserName.getDeclaringClass(), parserName.name());
        }
    }
}
