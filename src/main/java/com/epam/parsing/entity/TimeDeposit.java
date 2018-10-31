package com.epam.parsing.entity;

public class TimeDeposit extends Deposit {

    private double minimumSum;
    private boolean isOnlineOpening;

    public TimeDeposit(String nameOfBank, String country, double profitability, int timeConstraints, String currencyType, double minimumSum, boolean isOnlineOpening) {
        super(nameOfBank, country, profitability, timeConstraints, currencyType);
        this.minimumSum = minimumSum;
        this.isOnlineOpening = isOnlineOpening;
    }

    public double getMinimumSum() {
        return minimumSum;
    }

    public void setMinimumSum(double minimumSum) {
        this.minimumSum = minimumSum;
    }

    public boolean isOnlineOpening() {
        return isOnlineOpening;
    }

    public void setOnlineOpening(boolean onlineOpening) {
        isOnlineOpening = onlineOpening;
    }

    //TODO ADD EQUALS AND HASHCODE
}
