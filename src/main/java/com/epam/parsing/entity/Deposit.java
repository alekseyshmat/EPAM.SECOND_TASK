package com.epam.parsing.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Deposit", propOrder = {
        "nameOfBank",
        "country",
        "profitability",
        "timeConstraints",
        "currencyType"

})
@XmlSeeAlso({
        SavingDeposit.class,
        TimeDeposit.class
})
public abstract class Deposit {
    @XmlElement(name = "nameOfBank", required = true)
//    @XmlID
    @XmlSchemaType(name = "string")
    private String nameOfBank;
    @XmlElement(name = "country", required = true)
    @XmlSchemaType(name = "string")
    private String country;
    @XmlElement(name = "profitability", required = true)
    @XmlSchemaType(name = "double")
    private double profitability;
    @XmlElement(name = "timeConstraints", required = true)
    @XmlSchemaType(name = "int")
    private int timeConstraints;
    @XmlElement(name = "currencyType", required = true)
    @XmlSchemaType(name = "string")
    private String currencyType;

  /*  public Deposit(String nameOfBank, String country, double profitability, int timeConstraints, String currencyType) {
        this.nameOfBank = nameOfBank;
        this.country = country;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
        this.currencyType = currencyType;
    }*/

    public Deposit() {
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(int timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "Deposit [ nameOfBank = " + nameOfBank + "\ncountry = " + country +
                "\nprofitability = " + profitability + "\ntime constraints = " + timeConstraints +
                "\ncurrencyType = " + currencyType + " ]";
    }
}
