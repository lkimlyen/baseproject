package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class GetListPromotionEntity implements Serializable {


    @SerializedName("listPromotion")
    @Expose
    private ArrayList<PromotionEntity> listPromotion;

    public ArrayList<PromotionEntity> getListPromotion() {
        return listPromotion;
    }

    public void setListPromotion(ArrayList<PromotionEntity> listPromotion) {
        this.listPromotion = listPromotion;
    }
}