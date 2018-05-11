package com.demo.architect.data.model.offline;

/**
 * Created by Skull on 21/03/2018.
 */

public class HistoryEntity {
    private String action, address;
    private double price;

    public HistoryEntity() {
    }

    public HistoryEntity(String action, String address, double price) {
        this.action = action;
        this.address = address;
        this.price = price;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
