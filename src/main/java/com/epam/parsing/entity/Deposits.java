package com.epam.parsing.entity;

import com.epam.parsing.entity.Deposit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

@XmlRootElement(name = "deposits")
public class Deposits {
  //  @XmlElementRef(name = "deposit", namespace = "http://www.example.com/deposits", type = JAXBElement.class)

    @XmlElement(name = "listOfDeposits")
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
