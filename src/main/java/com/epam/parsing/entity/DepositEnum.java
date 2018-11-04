package com.epam.parsing.entity;

public enum DepositEnum {
    NAMEOFBANK("nameOfBank"),
    COUNTRY("country"),
    PROFITABILITY("profitability"),
    TIMECONSTRAINTS("timeConstraints"),
    CURRENCYTYPE("currencyType"),
    CAPITALIZATION("capitalization"),
    CASHOUT("cashOut"),
    ONLINEOPENING("onlineOpening"),
    MINIMUMSIZE("minimumSum");

    private String value;

    DepositEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
