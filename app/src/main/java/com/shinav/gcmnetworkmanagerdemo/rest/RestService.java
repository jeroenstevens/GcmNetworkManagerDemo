package com.shinav.gcmnetworkmanagerdemo.rest;

import com.shinav.gcmnetworkmanagerdemo.rest.model.PhoneWriteModel;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface RestService {
    @GET("/phones") Observable<List<PhoneWriteModel>> getPhones();
}
