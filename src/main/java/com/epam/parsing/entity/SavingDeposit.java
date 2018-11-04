package com.epam.parsing.entity;

import javax.xml.bind.annotation.XmlElement;

public class SavingDeposit extends Deposit {

    @XmlElement(name = "capitalization")
    private double capitalization;
    @XmlElement(name = "cashOut")
    private boolean cashOut;

    public SavingDeposit(String nameOfBank, String country, double profitability, int timeConstraints, String currencyType, double capitalization, boolean cashOut) {
        super(nameOfBank, country, profitability, timeConstraints, currencyType);
        this.capitalization = capitalization;
        this.cashOut = cashOut;
    }

    public boolean isCashOut() {
        return cashOut;
    }

    public void setCashOut(boolean cashOut) {
        this.cashOut = cashOut;
    }

    public double getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(double capitalization) {
        this.capitalization = capitalization;
    }

    //TODO ADD EQUALS AND HASHCODE
}
