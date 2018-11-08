package com.epam.parsing.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
/*@XmlType(propOrder = {
        "deposit"
})*/
@XmlRootElement(name = "deposits")
public class Deposits {

//    @XmlElementRef(name = "deposit", namespace = "http://www.example.com/deposit")


    public Deposits() {
        listOfDeposits = new ArrayList<>();
    }

    protected List<JAXBElement<? extends Deposit>> deposit;

    public List<JAXBElement<? extends Deposit>> getDeposit() {
        if (deposit == null) {
            deposit = new ArrayList<>();
        }
        return this.deposit;
    }
    
    @XmlElementWrapper(name = "listOfDeposits")
    private List<Deposit> listOfDeposits;

    public List<Deposit> getListOfDeposits() {
        return listOfDeposits;
    }

    public boolean add(Deposit deposit) {
        return listOfDeposits.add(deposit);
    }

    public void setListOfDeposits(List<Deposit> listOfDeposits) {
        this.listOfDeposits = listOfDeposits;
    }

    @Override
    public String toString() {
        return "Deposits[listOfDeposits =" + listOfDeposits + "]";
    }

}
