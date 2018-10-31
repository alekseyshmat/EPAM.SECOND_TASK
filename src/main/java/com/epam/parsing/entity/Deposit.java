package com.epam.parsing.entity;

public abstract class Deposit {

    private String nameOfBank;
    private String country;
    private double profitability;
    private int timeConstraints;
    private String currencyType;

    public Deposit(String nameOfBank, String country, double profitability, int timeConstraints, String currencyType) {
        this.nameOfBank = nameOfBank;
        this.country = country;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
        this.currencyType = currencyType;
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
}
