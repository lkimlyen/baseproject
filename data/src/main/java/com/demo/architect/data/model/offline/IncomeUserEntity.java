package com.demo.architect.data.model.offline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Skull on 30/11/2017.
 */

public class IncomeUserEntity {
    @SerializedName("income")
    @Expose
    private String income;

    @SerializedName("bonus")
    @Expose
    private String bonus;

    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("ratingPoint")
    @Expose
    private String ratingPoint;

    @SerializedName("totalTask")
    @Expose
    private int totalTask;

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(String ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public int getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(int totalTask) {
        this.totalTask = totalTask;
    }
}
