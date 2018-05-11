package com.demo.merchandisemot.manager;

import com.demo.architect.data.model.NotificationEntity;
import com.demo.architect.data.model.NotificationEntity;

import java.util.ArrayList;
import java.util.List;

public class ListNotificationsManager {
    private List<NotificationEntity> listNotifications = new ArrayList<>();
    private static ListNotificationsManager instance;

    public static ListNotificationsManager getInstance() {
        if (instance == null) {
            instance = new ListNotificationsManager();
        }
        return instance;
    }

    public void setListNotifications(List<NotificationEntity> listNotifications) {
        this.listNotifications = listNotifications;
    }

    public List<NotificationEntity> getListNotifications() {
        return listNotifications;
    }

    public void removeNewNotification(String id) {
        for (NotificationEntity item: listNotifications) {
            if (item.getNotificationId().equals(id)) {
                listNotifications.remove(item);
                return;
            }
        }
    }
}
