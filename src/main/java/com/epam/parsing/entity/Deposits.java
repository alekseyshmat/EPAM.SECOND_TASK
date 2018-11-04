package com.epam.parsing.entity;

import com.epam.parsing.entity.Deposit;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Deposits {

    @XmlElement(name ="deposits")
    private List<Deposit> listOfDeposits;

    public Deposits() {
    }

    public List<Deposit> getListOfDeposits() {
        return listOfDeposits;
    }

    public void setListOfDeposits(List<Deposit> listOfDeposits) {
        this.listOfDeposits = listOfDeposits;
    }

    //todo override methods
}
