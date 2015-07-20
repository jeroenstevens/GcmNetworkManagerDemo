package com.shinav.gcmnetworkmanagerdemo.injection.module;

import android.content.Context;

import com.shinav.gcmnetworkmanagerdemo.injection.annotation.ForApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    Context applicationContext;

    public ApplicationModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides @ForApplication Context provideApplicationContext() {
        return applicationContext;
    }
}
