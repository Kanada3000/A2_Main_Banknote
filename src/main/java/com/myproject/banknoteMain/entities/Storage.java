package com.myproject.banknoteMain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Storage {
    private UUID id;
    private int quantity;
    private Banknote banknote;

    public Storage() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setBanknote(Banknote banknotes) {
        this.banknote = banknotes;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public Banknote getBanknote() {
        return banknote;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Storage id = " + id + ", banknotes = " + banknote + ", quantity = " + quantity;
    }
}