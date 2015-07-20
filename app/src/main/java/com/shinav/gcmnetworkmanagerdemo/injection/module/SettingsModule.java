package com.shinav.gcmnetworkmanagerdemo.injection.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {

    public static final String API_ENDPOINT = "api_endpoint";
    //    public static String apiEndpoint = "http://10.0.1.25:8882";
    public static String apiEndpoint = "http://10.0.2.2:8882";

    @Provides @Named(API_ENDPOINT) String getApiRoot() {
        return apiEndpoint;
    }
}
