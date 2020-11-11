package com.myproject.banknoteMain.entities.dto;

import java.util.List;

import com.myproject.banknoteMain.entities.Banknote;
import com.myproject.banknoteMain.entities.BanknoteMachine;
import com.myproject.banknoteMain.entities.Customer;

public class NewOrderDTO {
    private BanknoteMachine banknoteMachine;
    private Customer customer;
    private List<Banknote> banknote;

    public void setBanknoteMachine(BanknoteMachine banknoteMachine) {
        this.banknoteMachine = banknoteMachine;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBanknote(List<Banknote> banknote) {
        this.banknote = banknote;
    }

    public BanknoteMachine getBanknoteMachine() {
        return banknoteMachine;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Banknote> getBanknote() {
        return banknote;
    }
}
