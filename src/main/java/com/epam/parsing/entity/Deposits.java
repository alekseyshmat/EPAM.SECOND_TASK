package com.epam.parsing.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "deposits", namespace = "http://www.example.com/deposits")
public class Deposits {

    @XmlElement(name = "listOfDeposits")
    private List<Deposit> listOfDeposits = new ArrayList<>();

    public Deposits() {
        super();
    }

    public List<Deposit> getListOfDeposits() {
        return listOfDeposits;
    }

    public boolean add(Deposit deposit) {
        return listOfDeposits.add(deposit);
    }


    @Override
    public String toString() {
        return "Deposits[listOfDeposits =" + listOfDeposits + "]";
    }
}
