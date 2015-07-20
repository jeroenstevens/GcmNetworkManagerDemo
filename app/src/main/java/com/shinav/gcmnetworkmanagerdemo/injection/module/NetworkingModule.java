package com.shinav.gcmnetworkmanagerdemo.injection.module;

import com.shinav.gcmnetworkmanagerdemo.rest.RestService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module
public class NetworkingModule {
    @Provides public RestService provideRestService(@Named(SettingsModule.API_ENDPOINT) String endpoint) {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(endpoint).build();
        return adapter.create(RestService.class);
    }
}
