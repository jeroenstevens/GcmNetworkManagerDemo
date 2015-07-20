package com.shinav.gcmnetworkmanagerdemo.injection.module;

import android.content.Context;

import com.shinav.gcmnetworkmanagerdemo.db.helper.DbOpenHelper;
import com.shinav.gcmnetworkmanagerdemo.injection.annotation.ForApplication;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides @Singleton public SqlBrite provideSqlBrite(@ForApplication Context context) {
        return SqlBrite.create(new DbOpenHelper(context));
    }
}
