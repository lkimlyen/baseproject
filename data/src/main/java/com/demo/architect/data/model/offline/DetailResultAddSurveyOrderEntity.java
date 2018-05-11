package com.demo.architect.data.model.offline;

import com.demo.architect.data.model.OrderEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Skull on 25/03/2018.
 */

public class DetailResultAddSurveyOrderEntity implements Serializable {

    @SerializedName("orderId")
    @Expose
    private String orderId;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("state")
    @Expose
    private String state;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
