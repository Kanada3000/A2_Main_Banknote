package com.myproject.banknoteMain.entities;

import java.util.UUID;

public class BanknoteMachine {
//    private UUID id;
    private Currency currency;
    private int productionSpeed;

    public BanknoteMachine() {
    }

    public BanknoteMachine(Currency currency, int productionSpeed) {
        this.currency = currency;
        this.productionSpeed = productionSpeed;
    }

//    public void setId(UUID id) {
//        this.id = id;
//    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setProductionSpeed(int productionSpeed) {
        this.productionSpeed = productionSpeed;
    }

//    public UUID getId() {
//        return id;
//    }

    public Currency getCurrency() {
        return currency;
    }

    public int getProductionSpeed() {
        return productionSpeed;
    }

    @Override
    public String toString() {
        return "Machine production speed = " + productionSpeed + " per second"
                + ", currency = " + currency;
    }
}
