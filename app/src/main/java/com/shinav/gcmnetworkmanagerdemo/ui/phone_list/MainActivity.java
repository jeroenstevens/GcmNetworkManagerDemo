package com.shinav.gcmnetworkmanagerdemo.ui.phone_list;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.shinav.gcmnetworkmanagerdemo.R;
import com.shinav.gcmnetworkmanagerdemo.db.table.PhoneTable;
import com.shinav.gcmnetworkmanagerdemo.injection.Injector;
import com.shinav.gcmnetworkmanagerdemo.model.Phone;
import com.shinav.gcmnetworkmanagerdemo.sync.GcmSyncService;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


public class MainActivity extends AppCompatActivity {

    @Inject SqlBrite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Injector.obtain(this).inject(this);

        startService(new Intent(this, GcmSyncService.class));
    }

    @Override protected void onResume() {
        super.onResume();

        db.createQuery(
                PhoneTable.TABLE,
                "SELECT * FROM " + PhoneTable.TABLE
        )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SqlBrite.Query>() {
                    @Override public void call(SqlBrite.Query query) {
                        Cursor c = query.run();
                        try {
                            Log.e("MainActivity", "Amount of phones : " + c.getCount());
                        } finally {
                            c.close();
                        }
                    }
                });
    }
}
