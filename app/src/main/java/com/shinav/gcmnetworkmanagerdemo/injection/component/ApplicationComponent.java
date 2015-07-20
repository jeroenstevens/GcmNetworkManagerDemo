package com.shinav.gcmnetworkmanagerdemo.injection.component;

import com.shinav.gcmnetworkmanagerdemo.injection.annotation.ForApplication;
import com.shinav.gcmnetworkmanagerdemo.injection.module.ApplicationModule;
import com.shinav.gcmnetworkmanagerdemo.injection.module.DatabaseModule;
import com.shinav.gcmnetworkmanagerdemo.injection.module.NetworkingModule;
import com.shinav.gcmnetworkmanagerdemo.injection.module.SettingsModule;
import com.shinav.gcmnetworkmanagerdemo.sync.GcmSyncService;
import com.shinav.gcmnetworkmanagerdemo.ui.phone_list.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@ForApplication
@Component(modules = {
        ApplicationModule.class,
        SettingsModule.class,
        NetworkingModule.class,
        DatabaseModule.class
})
public interface ApplicationComponent {
    void inject(GcmSyncService gcmSyncService);

    void inject(MainActivity mainActivity);
}
