package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Skull on 18/12/2017.
 */

public class IncomeWalletEntity implements Serializable {

    @SerializedName("orderNumberSuccessful")
    @Expose
    private int orderNumberSuccessful;

    @SerializedName("totalIncome")
    @Expose
    private String totalIncome;

    @SerializedName("listIncome")
    @Expose
    private ArrayList<IncomeEntity> listIncome;

    public int getOrderNumberSuccessful() {
        return orderNumberSuccessful;
    }

    public void setOrderNumberSuccessful(int orderNumberSuccessful) {
        this.orderNumberSuccessful = orderNumberSuccessful;
    }

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public ArrayList<IncomeEntity> getListIncome() {
        return listIncome;
    }

    public void setListIncome(ArrayList<IncomeEntity> listIncome) {
        this.listIncome = listIncome;
    }
}