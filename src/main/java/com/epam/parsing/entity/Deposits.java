package com.epam.parsing.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "deposits")
public class Deposits {
    public Deposits() {
        depositList = new ArrayList<>();
    }

    private List<Deposit> depositList;

    @XmlElementRef(name = "deposit", namespace = "http://www.example.com/deposits", type = JAXBElement.class)
    private List<JAXBElement<? extends Deposit>> deposit;

    public List<JAXBElement<? extends Deposit>> getDeposit() {
        if (deposit == null) {
            deposit = new ArrayList<>();
        }
        return this.deposit;
    }

    public void addList() {
        for (JAXBElement element : getDeposit()) {
            depositList.add((Deposit) element.getValue());
        }
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    @Override
    public String toString() {
        return "Deposits[listOfDeposits =" + deposit + "]";
    }


}
