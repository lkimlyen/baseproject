package com.demo.merchandisemot.screen.dashboard;


import com.goitho.employeeapp.app.base.BasePresenter;
import com.goitho.employeeapp.app.base.BaseView;

/**
 * Created by admin on 4/9/17.
 */

public interface DashboardContract {
    interface View extends BaseView<Presenter> {
        void setNotificationNumber(int number);
    }

    interface Presenter extends BasePresenter {
        void loadNewNoti();

    }
}
