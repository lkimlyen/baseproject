package com.demo.architect.data.model.offline;

import java.util.Date;

/**
 * Created by Skull on 25/03/2018.
 */

public class ReceiveOrderEntity { private String title;
    private String customerAddress;
    private Date date;
    private int state;
    private String orderId;

    public ReceiveOrderEntity() {
    }

    public ReceiveOrderEntity(String orderId, String title, String customerAddress, Date date, int state) {
        this.orderId = orderId;
        this.title = title;
        this.customerAddress = customerAddress;
        this.date = date;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
