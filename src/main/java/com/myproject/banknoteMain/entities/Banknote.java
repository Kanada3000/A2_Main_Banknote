package com.myproject.banknoteMain.entities;

import java.util.UUID;


public class Banknote {
    private UUID id;
    private Currency currency;
    private BanknoteMachine madeBy;

    public Banknote() {
    }

    public Banknote(Currency currency, BanknoteMachine madeBy) {
        this.currency = currency;
        this.madeBy = madeBy;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMadeBy(BanknoteMachine madeBy){
        this.madeBy = madeBy;
    }

    public Currency getCurrency() {
        return currency;
    }

    public UUID getId() {
        return id;
    }

    public BanknoteMachine getMadeBy() {
        return madeBy;
    }

    @Override
    public String toString() {
        return "Banknote id = " + id + ", currency = " + currency;
    }
}
