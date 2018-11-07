package com.epam.parsing.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SavingDeposit")
public class SavingDeposit extends Deposit {

    @XmlElement(name = "capitalization")
    private double capitalization;
    @XmlElement(name = "cashOut")
    private boolean cashOut;

    public SavingDeposit() {
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

    @Override
    public String toString() {
        return "Saving deposit [capitalization = " + capitalization + "\ncash out = " + cashOut + " ]";
    }
}
