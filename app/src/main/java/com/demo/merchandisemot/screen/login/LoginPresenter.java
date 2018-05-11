package com.demo.merchandisemot.screen.login;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.demo.architect.data.repository.base.local.LocalRepository;
import com.demo.architect.domain.usecase.BaseUseCase;
import com.demo.architect.domain.usecase.GetListNotificationsUsecase;
import com.demo.architect.domain.usecase.LinkContactUsecase;
import com.demo.architect.domain.usecase.LoginUsecase;
import com.demo.architect.domain.usecase.ResetPasswordUsecase;
import com.goitho.employeeapp.app.CoreApplication;
import com.goitho.employeeapp.manager.ListContactManager;
import com.goitho.employeeapp.manager.ListNotificationsManager;
import com.goitho.employeeapp.manager.UserManager;
import com.google.gson.Gson;

import javax.inject.Inject;

/**
 * Created by MSI on 26/11/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final String TAG = LoginPresenter.class.getName();
    private final LoginContract.View view;
    private final ResetPasswordUsecase resetPasswordUsecase;

    @Inject
    LocalRepository localRepository;

    LoginUsecase loginUsecase;
    final GetListNotificationsUsecase getListNotificationsUsecase;
    private final LinkContactUsecase linkContactUsecase;

    @Inject
    LoginPresenter(@NonNull LoginContract.View view, ResetPasswordUsecase resetPasswordUsecase,
                   LoginUsecase loginUsecase, GetListNotificationsUsecase getListNotificationsUsecase, LinkContactUsecase linkContactUsecase) {
        this.view = view;
        this.resetPasswordUsecase = resetPasswordUsecase;
        this.loginUsecase = loginUsecase;
        this.getListNotificationsUsecase = getListNotificationsUsecase;
        this.linkContactUsecase = linkContactUsecase;
    }

    @Inject
    public void setupPresenter() {
        view.setPresenter(this);
    }


    @Override
    public void start() {
        Log.d(TAG, TAG + ".start() called");
    }

    @Override
    public void stop() {
        Log.d(TAG, TAG + ".stop() called");
    }

    @Override
    public void login(String username, String password) {
        view.showProgressBar();
        loginUsecase.executeIO(new LoginUsecase.RequestValue(username, password), new BaseUseCase.UseCaseCallback
                <LoginUsecase.ResponseValue, LoginUsecase.ErrorValue>() {
            @Override
            public void onSuccess(LoginUsecase.ResponseValue successResponse) {
                Log.d(TAG, new Gson().toJson(successResponse.getEntity()));

                //Save user entity to shared preferences
                UserManager.getInstance().setUser(successResponse.getEntity());
                getContact();
            }

            @Override
            public void onError(LoginUsecase.ErrorValue errorResponse) {
                view.showError();
                view.hideProgressBar();
            }
        });
    }

    private void getContact() {
        linkContactUsecase.executeIO(new LinkContactUsecase.RequestValue(),
                new BaseUseCase.UseCaseCallback<LinkContactUsecase.ResponseValue,
                        LinkContactUsecase.ErrorValue>() {
                    @Override
                    public void onSuccess(LinkContactUsecase.ResponseValue successResponse) {
                        ListContactManager.getInstance().setContact(successResponse.linkContactEntity());

                        getNotification();
                    }

                    @Override
                    public void onError(LinkContactUsecase.ErrorValue errorResponse) {
                        view.showError();
                        view.hideProgressBar();
                    }
                });
    }

    private void getNotification() {
        getListNotificationsUsecase.executeIO(new GetListNotificationsUsecase.RequestValue(UserManager.getInstance()
                        .getUser()
                        .getUserId(), 0, 20),
                new BaseUseCase.UseCaseCallback<GetListNotificationsUsecase.ResponseValue, GetListNotificationsUsecase.ErrorValue>() {
                    @Override
                    public void onSuccess(GetListNotificationsUsecase.ResponseValue successResponse) {
                        ListNotificationsManager.getInstance().setListNotifications(successResponse.getEntity().getListNotification());
                        //Go to dashboard activity
                        view.startDashboardActivity();
                        view.hideProgressBar();
                    }

                    @Override
                    public void onError(GetListNotificationsUsecase.ErrorValue errorResponse) {
                        view.showError();
                        view.hideProgressBar();
                    }
                });
    }

    @Override
    public void resetPassword(String username, String phone, String newPassword) {
        view.showProgressBar();
        resetPasswordUsecase.executeIO(new ResetPasswordUsecase.RequestValue(username, phone), new BaseUseCase.UseCaseCallback
                <ResetPasswordUsecase.ResponseValue, ResetPasswordUsecase.ErrorValue>() {
            @Override
            public void onSuccess(ResetPasswordUsecase.ResponseValue successResponse) {
                Log.d(TAG, new Gson().toJson(successResponse.getEntity()));
//                Toast.makeText(CoreApplication.getInstance(), successResponse.getEntity().getData().getAuth_code() + "", Toast.LENGTH_SHORT).show();
                view.startPhoneVerificationActivity(successResponse.getEntity().getData().getUserId(), newPassword);
                view.hideProgressBar();
            }

            @Override
            public void onError(ResetPasswordUsecase.ErrorValue errorResponse) {
                view.showErrorResetPassword();
                view.hideProgressBar();
            }
        });
    }
}
