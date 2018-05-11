package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class GetDetailOrderEntity implements Serializable {


    @SerializedName("listOrderDetail")
    @Expose
    private ArrayList<OrderEntity> listOrderDetail;

    public ArrayList<OrderEntity> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(ArrayList<OrderEntity> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }
}