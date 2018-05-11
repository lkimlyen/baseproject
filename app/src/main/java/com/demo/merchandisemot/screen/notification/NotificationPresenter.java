package com.demo.merchandisemot.screen.notification;

import android.support.annotation.NonNull;
import android.util.Log;

import com.demo.architect.data.model.NotificationEntity;
import com.demo.architect.data.repository.base.local.LocalRepository;
import com.demo.architect.domain.usecase.BaseUseCase;
import com.demo.architect.domain.usecase.GetListNotificationsUsecase;
import com.demo.architect.domain.usecase.SetReadNotificationUsecase;
import com.goitho.employeeapp.manager.ListNotificationsManager;
import com.goitho.employeeapp.manager.UserManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Skull on 22/03/2018.
 */

public class NotificationPresenter implements NotificationContract.Presenter{

    private final String TAG = NotificationPresenter.class.getName();
    private final NotificationContract.View view;
    private GetListNotificationsUsecase getListNotificationsUsecase;
    private SetReadNotificationUsecase setReadNotificationUsecase;
    @Inject
    LocalRepository localRepository;

    @Inject
    NotificationPresenter(@NonNull NotificationContract.View view,
                          GetListNotificationsUsecase getListNotificationsUsecase,
                          SetReadNotificationUsecase setReadNotificationUsecase) {
        this.view = view;
        this.getListNotificationsUsecase = getListNotificationsUsecase;
        this.setReadNotificationUsecase = setReadNotificationUsecase;
    }

    @Inject
    public void setupPresenter() {
        view.setPresenter(this);
    }


    @Override
    public void start() {
        loadListNoti();
        Log.d(TAG, TAG + ".start() called");


    }

    public void loadListNoti() {
        view.showProgressBar();
        getListNotificationsUsecase.executeIO(new GetListNotificationsUsecase.RequestValue(UserManager.getInstance()
                        .getUser()
                        .getUserId(), 0, 20),
                new BaseUseCase.UseCaseCallback<GetListNotificationsUsecase.ResponseValue, GetListNotificationsUsecase.ErrorValue>() {
                    @Override
                    public void onSuccess(GetListNotificationsUsecase.ResponseValue successResponse) {
                        view.showListNoti(successResponse.getEntity().getListNotification());
                        view.setSwipeRefresh(false);
                        view.hideProgressBar();
                    }

                    @Override
                    public void onError(GetListNotificationsUsecase.ErrorValue errorResponse) {
                        view.setSwipeRefresh(false);
                        view.showError();
                        view.showImageRefresh(true);
                        view.hideProgressBar();
                    }
                });
    }

    @Override
    public void setReadNotification(String notificationId) {
        setReadNotificationUsecase.executeIO(new SetReadNotificationUsecase.RequestValue(UserManager.getInstance()
                        .getUser()
                        .getUserId(), notificationId),
                new BaseUseCase.UseCaseCallback<SetReadNotificationUsecase.ResponseValue, SetReadNotificationUsecase.ErrorValue>() {
                    @Override
                    public void onSuccess(SetReadNotificationUsecase.ResponseValue successResponse) {
                        ListNotificationsManager.getInstance().removeNewNotification(notificationId);
                    }

                    @Override
                    public void onError(SetReadNotificationUsecase.ErrorValue errorResponse) {
                    }
                });
    }


    @Override
    public void stop() {
        Log.d(TAG, TAG + ".stop() called");
    }




}

