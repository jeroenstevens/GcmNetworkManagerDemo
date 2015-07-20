package com.shinav.gcmnetworkmanagerdemo;

import android.app.Application;
import android.support.annotation.NonNull;

import com.shinav.gcmnetworkmanagerdemo.injection.Injector;
import com.shinav.gcmnetworkmanagerdemo.injection.component.DaggerApplicationComponent;
import com.shinav.gcmnetworkmanagerdemo.injection.module.ApplicationModule;

public class MyApplication extends Application {

    @Override public Object getSystemService(@NonNull String name) {
        if (Injector.matchesService(name)) {
            return DaggerApplicationComponent
                    .builder().applicationModule(new ApplicationModule(this)).build();
        }

        return super.getSystemService(name);
    }

}
