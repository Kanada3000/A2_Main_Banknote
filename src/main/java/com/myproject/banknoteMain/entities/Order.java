package com.myproject.banknoteMain.entities;

//import java.util.List;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private Customer customer;
    private BanknoteMachine banknoteMachine;
    private List<Banknote> banknote;

    public Order() {
    }

    public Order(List<Banknote> banknote, BanknoteMachine banknoteMachine, Customer customer) {
        this.customer = customer;
        this.banknoteMachine = banknoteMachine;
        this.banknote = banknote;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setMachine(BanknoteMachine banknoteMachine) {
        this.banknoteMachine = banknoteMachine;
    }

    public void setBanknote(List<Banknote> banknote) {
        this.banknote = banknote;
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BanknoteMachine getMachine() {
        return banknoteMachine;
    }

    public List<Banknote> getBanknote() {
        return banknote;
    }

    @Override
    public String toString() {
        return "Order id = " + id + ", banknote = " + banknote + ", machine = " + banknoteMachine + ", customer = "
                + customer;
    }
}
