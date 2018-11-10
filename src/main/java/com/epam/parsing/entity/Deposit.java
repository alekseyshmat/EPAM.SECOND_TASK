package com.epam.parsing.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Deposit", propOrder = {
        "nameOfBank",
        "country",
        "profitability",
        "timeConstraints",
        "currencyType"
})
@XmlSeeAlso({SavingDeposit.class, TimeDeposit.class})
public abstract class Deposit {

    @XmlAttribute(name = "bankId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String bankId;

    @XmlElement(name = "nameOfBank", required = true)
    @XmlSchemaType(name = "string")
    private String nameOfBank;

    @XmlElement(name = "country", required = true)
    private CountryEnum country;

    @XmlElement(name = "profitability", required = true)
    @XmlSchemaType(name = "double")
    private double profitability;

    @XmlElement(name = "timeConstraints", required = true)
    @XmlSchemaType(name = "int")
    private int timeConstraints;

    @XmlElement(name = "currencyType", required = true)
    @XmlSchemaType(name = "string")
    private String currencyType;

    public Deposit() {
    }

    public String getBankId() {
        if (bankId == null) {
            return "bankId";
        } else {
            return bankId;
        }
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
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
        return "Deposit [ " +
                "bankId = " + bankId +
                "nameOfBank = " + nameOfBank +
                "\ncountry = " + country +
                "\nprofitability = " + profitability +
                "\ntime constraints = " + timeConstraints +
                "\ncurrencyType = " + currencyType + " ]";
    }
}
