package com.epam.parsing.entity;

public class SavingDeposit extends Deposit {

    private double capitalization;
    private boolean isCashOut;

    public SavingDeposit(String nameOfBank, String country, double profitability, int timeConstraints, String currencyType, double capitalization, boolean isCashOut) {
        super(nameOfBank, country, profitability, timeConstraints, currencyType);
        this.capitalization = capitalization;
        this.isCashOut = isCashOut;
    }

    public boolean isCashOut() {
        return isCashOut;
    }

    public void setCashOut(boolean cashOut) {
        isCashOut = cashOut;
    }

    public double getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(double capitalization) {
        this.capitalization = capitalization;
    }

    //TODO ADD EQUALS AND HASHCODE
}
