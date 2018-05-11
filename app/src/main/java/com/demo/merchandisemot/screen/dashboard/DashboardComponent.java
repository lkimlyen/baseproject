package com.demo.merchandisemot.screen.dashboard;


import com.goitho.employeeapp.app.di.ActivityScope;
import com.goitho.employeeapp.screen.edit_account.EditAccountFragment;
import com.goitho.employeeapp.screen.edit_account.EditAccountModule;
import com.goitho.employeeapp.screen.edit_profile.EditProfileModule;
import com.goitho.employeeapp.screen.employeewallet.EmployeeWalletModule;
import com.goitho.employeeapp.screen.history.HistoryFragment;
import com.goitho.employeeapp.screen.history.HistoryModule;
import com.goitho.employeeapp.screen.income.IncomeModule;
import com.goitho.employeeapp.screen.notification.NotificationFragment;
import com.goitho.employeeapp.screen.notification.NotificationModule;
import com.goitho.employeeapp.screen.order.OrderFragment;
import com.goitho.employeeapp.screen.order.OrderModule;
import com.goitho.employeeapp.screen.promotion.PromotionFragment;
import com.goitho.employeeapp.screen.promotion.PromotionModule;
import com.goitho.employeeapp.screen.screen_goitho.profile.ProfileModule;
import com.goitho.employeeapp.screen.technique.TechniqueModule;
import com.goitho.employeeapp.screen.wallet_pay.WalletPayFragment;
import com.goitho.employeeapp.screen.wallet_pay.WalletPayModule;

import dagger.Subcomponent;

/**
 * Created by admin on 5/18/17.
 */
@ActivityScope
@Subcomponent(modules = {
        OrderModule.class,
        EmployeeWalletModule.class,
        ProfileModule.class,
        HistoryModule.class,
        PromotionModule.class,
        NotificationModule.class,
        DashboardModule.class})
public interface DashboardComponent {
    void inject(DashboardFragment fragment);
}


