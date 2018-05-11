package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class WalletEntity implements Serializable {

    @SerializedName("paymentWallet")
    @Expose
    private String paymentWallet;

    @SerializedName("incomeWallet")
    @Expose
    private String incomeWallet;

    public String getPaymentWallet() {
        return paymentWallet;
    }

    public void setPaymentWallet(String paymentWallet) {
        this.paymentWallet = paymentWallet;
    }

    public String getIncomeWallet() {
        return incomeWallet;
    }

    public void setIncomeWallet(String incomeWallet) {
        this.incomeWallet = incomeWallet;
    }
}