package com.demo.merchandisemot.screen.notification;

import com.demo.architect.data.model.NotificationEntity;
import com.goitho.employeeapp.app.base.BasePresenter;
import com.goitho.employeeapp.app.base.BaseView;

import java.util.List;

/**
 * Created by Skull on 22/03/2018.
 */

public interface NotificationContract {
    interface View extends BaseView<Presenter> {
        void showListNoti(List<NotificationEntity> list);
        void setSwipeRefresh(boolean isRefresh);
        void showImageRefresh(boolean isShow);
        void showError();
        void refreshNewNotificationInNavigation();
    }

    interface Presenter extends BasePresenter {
        void loadListNoti();
        void setReadNotification(String notificationId);
    }
}

