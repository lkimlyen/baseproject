package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Skull on 23/04/2018.
 */
public class GetNewNotificationEntity {
    @SerializedName("countNew")
    @Expose
    private Integer countNew;
    @SerializedName("newNotification")
    @Expose
    private List<NotificationEntity> newNotification = null;

    public Integer getCountNew() {
        return countNew;
    }

    public void setCountNew(Integer countNew) {
        this.countNew = countNew;
    }

    public List<NotificationEntity> getNewNotification() {
        return newNotification;
    }

    public void setNewNotification(List<NotificationEntity> newNotification) {
        this.newNotification = newNotification;
    }

}