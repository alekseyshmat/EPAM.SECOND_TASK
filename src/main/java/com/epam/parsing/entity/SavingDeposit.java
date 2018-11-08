package com.epam.parsing.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SavingDeposit")
public class SavingDeposit extends Deposit {

    @XmlElement(name = "capitalization")
    @XmlSchemaType(name = "double")
    private double capitalization;
    @XmlElement(name = "cashOut")
    @XmlSchemaType(name = "boolean")
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
        return "Saving deposit: \n[capitalization = " + capitalization + "\ncash out = " + cashOut + " ]\n";
    }
}
