package com.shinav.gcmnetworkmanagerdemo.sync;

import android.util.Log;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.TaskParams;
import com.shinav.gcmnetworkmanagerdemo.db.table.PhoneTable;
import com.shinav.gcmnetworkmanagerdemo.injection.Injector;
import com.shinav.gcmnetworkmanagerdemo.model.Phone;
import com.shinav.gcmnetworkmanagerdemo.rest.RestService;
import com.shinav.gcmnetworkmanagerdemo.rest.model.PhoneWriteModel;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;

import static com.google.android.gms.gcm.Task.NETWORK_STATE_ANY;

public class GcmSyncService extends GcmTaskService {

    //    public static final int INTERVAL_IN_SECONDS = 3600 * 24;
    public static final int INTERVAL_IN_SECONDS = 30;
    private static final String TAG = "periodic-sync";

    @Inject RestService restService;
    @Inject SqlBrite db;

    @Override public void onCreate() {
        super.onCreate();

        Injector.obtain(this).inject(this);
        scheduleSync();
    }

    private void scheduleSync() {
        GcmNetworkManager.getInstance(this).schedule(createPeriodicSyncTask());
        Log.e("GcmSyncService", TAG + " scheduled");
    }

    private PeriodicTask createPeriodicSyncTask() {
        return new PeriodicTask.Builder()
                .setService(GcmSyncService.class)
                .setPeriod(INTERVAL_IN_SECONDS)
                .setFlex(INTERVAL_IN_SECONDS - 20)
                .setTag(TAG)
                .setPersisted(true)
                .setRequiredNetwork(NETWORK_STATE_ANY)
                .setUpdateCurrent(true)
                .setRequiresCharging(false)
                .build();
    }

    @Override public int onRunTask(TaskParams taskParams) {
        Log.e("GcmSyncService", TAG + " run");

        return performSync();
    }

    private int performSync() {
        syncPhones();

        Log.e("GcmSyncService", TAG + " performed");
        return GcmNetworkManager.RESULT_SUCCESS;
    }

    private void syncPhones() {

        restService.getPhones().subscribe(new Action1<List<PhoneWriteModel>>() {
            @Override public void call(List<PhoneWriteModel> phoneWriteModels) {

                for (PhoneWriteModel phoneWriteModel : phoneWriteModels) {

                    Phone phone = new Phone(
                            phoneWriteModel.model,
                            phoneWriteModel.brand
                    );

                    db.insert(PhoneTable.TABLE, phone.toContentValues());
                }

            }
        });

    }

}
