package com.epam.parsing.storage;

import com.epam.parsing.entity.Deposit;

import java.util.ArrayList;
import java.util.List;

public class Deposits {

    private List<Deposit> listOfDeposits = new ArrayList<Deposit>();

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
