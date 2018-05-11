package com.demo.merchandisemot.screen.dashboard;

import android.support.annotation.NonNull;
import android.util.Log;

import com.demo.architect.data.repository.base.local.LocalRepository;
import com.demo.architect.domain.usecase.BaseUseCase;
import com.demo.architect.domain.usecase.GetNewNotificationsUsecase;
import com.goitho.employeeapp.manager.ListNotificationsManager;
import com.goitho.employeeapp.manager.UserManager;

import javax.inject.Inject;

/**
 * Created by admin on 4/9/17.
 */

public class DashboardPresenter implements DashboardContract.Presenter{

    private final String TAG = DashboardPresenter.class.getName();
    private final DashboardContract.View view;

    private GetNewNotificationsUsecase getNewNotificationsUsecase;

    @Inject
    LocalRepository localRepository;

    @Inject
    DashboardPresenter(@NonNull DashboardContract.View view,
                       GetNewNotificationsUsecase getNewNotificationsUsecase) {
        this.view = view;
        this.getNewNotificationsUsecase = getNewNotificationsUsecase;
    }

    @Inject
    public void setupPresenter() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        Log.d(TAG, TAG + ".start() called");
        loadNewNoti();
    }

    @Override
    public void stop() {
        Log.d(TAG, TAG + ".stop() called");
    }

    @Override
    public void loadNewNoti() {
        getNewNotificationsUsecase.executeIO(new GetNewNotificationsUsecase.RequestValue(UserManager.getInstance()
                        .getUser()
                        .getUserId()),
                new BaseUseCase.UseCaseCallback<GetNewNotificationsUsecase.ResponseValue, GetNewNotificationsUsecase.ErrorValue>() {
                    @Override
                    public void onSuccess(GetNewNotificationsUsecase.ResponseValue successResponse) {
                        ListNotificationsManager.getInstance().setListNotifications(successResponse.getEntity().getNewNotification());
                        view.setNotificationNumber(successResponse.getEntity().getNewNotification().size());
                    }

                    @Override
                    public void onError(GetNewNotificationsUsecase.ErrorValue errorResponse) {
                        //view.showError();
                    }
                });
    }
}
