package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class EditDetailOrderEntity implements Serializable {

    @SerializedName("errorCode")
    @Expose
    private int errorCode;


    @SerializedName("listOrderDetail")
    @Expose
    private ArrayList<OrderEntity> listOrderDetail;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ArrayList<OrderEntity> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(ArrayList<OrderEntity> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }
}