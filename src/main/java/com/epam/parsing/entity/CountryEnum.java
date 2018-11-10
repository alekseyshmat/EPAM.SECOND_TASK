package com.epam.parsing.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Country")
@XmlEnum
public enum CountryEnum {
    Belarus,
    Russia,
    Ukraine,
    Poland,
    Latvia,
    Germany,
    GreatBritain,
    USA;

    public String value() {
        return name();
    }

    public static CountryEnum fromValue(String nameOfCountry) {
        return valueOf(nameOfCountry);
    }
}
