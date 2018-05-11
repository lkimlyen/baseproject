package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skull on 16/04/2018.
 */
public class GetListNotificationEntity implements Serializable {
    @SerializedName("listNotification")
    @Expose
    private List<NotificationEntity> listNotification = null;

    public List<NotificationEntity> getListNotification() {
        return listNotification;
    }

    public void setListNotification(List<NotificationEntity> listNotification) {
        this.listNotification = listNotification;
    }

}