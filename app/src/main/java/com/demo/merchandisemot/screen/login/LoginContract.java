package com.demo.merchandisemot.screen.login;

import com.goitho.employeeapp.app.base.BasePresenter;
import com.goitho.employeeapp.app.base.BaseView;

/**
 * Created by MSI on 26/11/2017.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void startRegisterActivity();
        void startDialogForgetPass();
        void startDashboardActivity();
        void startPhoneVerificationActivity(String userId, String newPassword);
        void showError();
        void showErrorResetPassword();
    }

    interface Presenter extends BasePresenter {
        void login(String username, String password);
        void resetPassword(String username, String phone, String newPassword);
    }
}
