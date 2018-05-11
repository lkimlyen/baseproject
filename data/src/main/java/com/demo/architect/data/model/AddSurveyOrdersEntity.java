package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.DetailResultAddSurveyOrderEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AddSurveyOrdersEntity implements Serializable {


    @SerializedName("listOrder")
    @Expose
    private ArrayList<DetailResultAddSurveyOrderEntity> listOrder;

    public ArrayList<DetailResultAddSurveyOrderEntity> getListOrder() {
        return listOrder;
    }

    public void setListOrder(ArrayList<DetailResultAddSurveyOrderEntity> listOrder) {
        this.listOrder = listOrder;
    }
}