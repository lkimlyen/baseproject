package com.demo.merchandisemot.screen.dashboard;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 4/8/17.
 */
@Module
public class DashboardModule {
    private final DashboardContract.View view;

    public DashboardModule(DashboardContract.View view) {
        this.view = view;
    }


    @Provides
    DashboardContract.View provideDashboardContractView() {
        return this.view;
    }
}
