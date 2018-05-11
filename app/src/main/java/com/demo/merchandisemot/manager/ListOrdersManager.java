package com.demo.merchandisemot.manager;

import com.demo.architect.data.model.OrderEntity;

import java.util.ArrayList;

public class ListOrdersManager {
    private ArrayList<OrderEntity> listOrders = new ArrayList<>();
    private static ListOrdersManager instance;

    public static ListOrdersManager getInstance() {
        if (instance == null) {
            instance = new ListOrdersManager();
        }
        return instance;
    }

    public void setListOrders(ArrayList<OrderEntity> listOrders) {
        this.listOrders = listOrders;
    }

    public void updateEntity(ArrayList<OrderEntity> listOrdersNew) {
        for (OrderEntity orderEntityNew : listOrdersNew) {
            for (OrderEntity orderEntity : listOrders) {
                if (orderEntity.getOrderId().equals(orderEntityNew.getOrderId())) {
                    listOrders.set(listOrders.indexOf(orderEntity), orderEntityNew);
                }
            }
        }
    }

    public void addListOrders(ArrayList<OrderEntity> listOrders) {
        this.listOrders.addAll(listOrders);
    }

    public ArrayList<OrderEntity> getListOrders() {
        return listOrders;
    }

    public OrderEntity getOrderEntityById(String orderId) {
        for (OrderEntity orderEntity : listOrders) {
            if (orderEntity.getOrderId().equals(orderId)) {
                return orderEntity;
            }
        }
        return null;
    }
}
