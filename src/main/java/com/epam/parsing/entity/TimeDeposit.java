package com.epam.parsing.entity;

import javax.xml.bind.annotation.XmlElement;

public class TimeDeposit extends Deposit {

    @XmlElement(name = "minimumSum")
    private double minimumSum;
    @XmlElement(name = "onlineOpening")
    private boolean onlineOpening;

    public TimeDeposit(String nameOfBank, String country, double profitability, int timeConstraints, String currencyType, double minimumSum, boolean onlineOpening) {
        super(nameOfBank, country, profitability, timeConstraints, currencyType);
        this.minimumSum = minimumSum;
        this.onlineOpening = onlineOpening;
    }

    public TimeDeposit() {
        super();
    }

    public double getMinimumSum() {
        return minimumSum;
    }

    public void setMinimumSum(double minimumSum) {
        this.minimumSum = minimumSum;
    }

    public boolean isOnlineOpening() {
        return onlineOpening;
    }

    public void setOnlineOpening(boolean onlineOpening) {
        this.onlineOpening = onlineOpening;
    }

    //TODO ADD EQUALS AND HASHCODE
}
