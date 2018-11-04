package com.epam.parsing.parser;

import com.epam.parsing.entity.Deposit;
import com.epam.parsing.entity.Deposits;
import com.epam.parsing.entity.SavingDeposit;
import com.epam.parsing.entity.TimeDeposit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

public class ObjectFactory {

    private final static QName _Deposit_QNAME =
            new QName("http://www.example.com/deposits", "Deposit");
    private final static QName _TimeDeposit_QNAME =
            new QName("http://www.example.com/deposits", "timeDeposit");
    private final static QName _SavingDeposit_QNAME =
            new QName("http://www.example.com/deposits", "savingDeposit");
    public ObjectFactory() {
    }
    public Deposits createDeposits() {
        return new Deposits();
    }
   /* public Deposit createPersonType() {
        return new Deposit();
    }*/
    public TimeDeposit createTimeDeposit() {
        return new TimeDeposit();
    }
    public SavingDeposit createSavingDeposit() {
        return new SavingDeposit();
    }
    @XmlElementDecl(namespace = "http://www.example.com/deposits", name = "Deposit")
    public JAXBElement<Deposit> createPerson(Deposit value) {
        return new JAXBElement<Deposit>(_Deposit_QNAME, Deposit.class, null, value);
    }
    @XmlElementDecl(namespace = "http://www.example.com/deposits", name = "timeDeposit",
            substitutionHeadNamespace = "http://www.example.com/deposits",
            substitutionHeadName = "abstractDeposit")
    public JAXBElement<TimeDeposit> createTimeDeposit(TimeDeposit value) {
        return new JAXBElement<TimeDeposit>(_TimeDeposit_QNAME, TimeDeposit.class, null, value);
    }
    @XmlElementDecl(namespace = "http://www.example.com/deposits", name = "savingDeposit",
            substitutionHeadNamespace = "http://www.example.com/deposits",
            substitutionHeadName = "Deposit")
    public JAXBElement<SavingDeposit> createSavingDeposit(SavingDeposit value) {
        return new JAXBElement<SavingDeposit>(_SavingDeposit_QNAME, SavingDeposit.class, null, value);
    }
}
