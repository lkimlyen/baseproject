package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Skull on 18/04/2018.
 */
public class ListHistoryEntity {

    @SerializedName("sucessOrder")
    @Expose
    private Integer sucessOrder;

    @SerializedName("failedOder")
    @Expose
    private Integer failedOder;

    @SerializedName("listOrders")
    @Expose
    private List<OrderEntity> listOrders = null;

    public Integer getFailedOder() {
        return failedOder;
    }

    public void setFailedOder(Integer failedOder) {
        this.failedOder = failedOder;
    }

    public List<OrderEntity> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<OrderEntity> listOrders) {
        this.listOrders = listOrders;
    }

    public Integer getSucessOrder() {
        return sucessOrder;
    }

    public void setSucessOrder(Integer sucessOrder) {
        this.sucessOrder = sucessOrder;
    }
}
