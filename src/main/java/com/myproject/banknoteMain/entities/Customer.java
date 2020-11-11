package com.myproject.banknoteMain.entities;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String surname;
    private String bank;

    public Customer() {
    }

    public Customer(String name, String surname, String bank) {
        this.name = name;
        this.surname = surname;
        this.bank = bank;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBank() {
        return bank;
    }

    @Override
    public String toString() {
        return ("Customer id = " + id + ", name = " + name + ", surname = " + surname + ", bank = " + bank);
    }
}
