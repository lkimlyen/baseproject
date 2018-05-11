package com.demo.merchandisemot.screen.notification;

import com.goitho.employeeapp.app.di.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by Skull on 22/03/2018.
 */

@ActivityScope
@Subcomponent(modules = {NotificationModule.class})
public interface NotificationComponent {
    void inject(NotificationActivity activity);

}
