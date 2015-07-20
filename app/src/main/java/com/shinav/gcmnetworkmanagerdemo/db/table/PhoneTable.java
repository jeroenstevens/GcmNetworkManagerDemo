package com.shinav.gcmnetworkmanagerdemo.db.table;

import android.provider.BaseColumns;

public interface PhoneTable {
    String TABLE = "phone";
    String ID = TABLE + BaseColumns._ID;
    String MODEL = TABLE + "_model";
    String BRAND = TABLE + "_brand";
}
