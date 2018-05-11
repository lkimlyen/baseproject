package com.demo.architect.data.model.offline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Skull on 30/11/2017.
 */

public class IncomeEntity {
    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("acceptanceTime")
    @Expose
    private String acceptanceTime;

    @SerializedName("money")
    @Expose
    private String money;

    @SerializedName("orderId")
    @Expose
    private String orderId;

    @SerializedName("note")
    @Expose
    private String note;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(String acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
