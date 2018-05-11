package com.demo.merchandisemot.screen.notification;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Skull on 22/03/2018.
 */

@Module
public class NotificationModule {
    private final NotificationContract.View NotificationContractView;

    public NotificationModule(NotificationContract.View NotificationContractView) {
        this.NotificationContractView = NotificationContractView;
    }

    @Provides
    @NonNull
    NotificationContract.View provideNotificationContractView() {
        return this.NotificationContractView;
    }
}
