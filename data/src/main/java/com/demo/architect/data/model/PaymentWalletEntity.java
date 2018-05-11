package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.BonusEntity;
import com.demo.architect.data.model.offline.IncomeEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Skull on 18/12/2017.
 */

public class PaymentWalletEntity implements Serializable {

    @SerializedName("cost")
    @Expose
    private String cost;

    @SerializedName("bonus")
    @Expose
    private String bonus;

    @SerializedName("payment")
    @Expose
    private String payment;

    @SerializedName("paymentWallet")
    @Expose
    private String paymentWallet;

    @SerializedName("listBonus")
    @Expose
    private ArrayList<BonusEntity> listBonus;

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymentWallet() {
        return paymentWallet;
    }

    public void setPaymentWallet(String paymentWallet) {
        this.paymentWallet = paymentWallet;
    }

    public ArrayList<BonusEntity> getListBonus() {
        return listBonus;
    }

    public void setListBonus(ArrayList<BonusEntity> listBonus) {
        this.listBonus = listBonus;
    }
}