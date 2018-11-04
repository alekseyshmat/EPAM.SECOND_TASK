package com.epam.parsing.parser;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.exception.ParserException;

import java.util.List;

public interface Parser {

    List<Deposit> parser(String path) throws ParserException;
}
