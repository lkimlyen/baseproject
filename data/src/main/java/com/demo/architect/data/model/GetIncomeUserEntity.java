package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.IncomeEntity;
import com.demo.architect.data.model.offline.IncomeUserEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Skull on 18/12/2017.
 */

public class GetIncomeUserEntity implements Serializable {

    @SerializedName("listIncomeUser")
    @Expose
    private ArrayList<IncomeUserEntity> listIncomeUser;

    public ArrayList<IncomeUserEntity> getListIncomeUser() {
        return listIncomeUser;
    }

    public void setListIncomeUser(ArrayList<IncomeUserEntity> listIncomeUser) {
        this.listIncomeUser = listIncomeUser;
    }
}