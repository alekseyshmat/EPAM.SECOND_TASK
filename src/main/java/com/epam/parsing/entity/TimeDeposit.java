package com.epam.parsing.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeDeposit")

public class TimeDeposit extends Deposit {

    @XmlElement(name = "minimumSum")
    private double minimumSum;
    @XmlElement(name = "onlineOpening")
    private boolean onlineOpening;

    public TimeDeposit() {
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

    @Override
    public String toString() {
        return "Time deposit: \n[minimum sum = " + minimumSum + "\nonline opening = " + onlineOpening + " ]\n";
    }
}
