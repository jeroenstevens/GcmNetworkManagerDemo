package com.shinav.gcmnetworkmanagerdemo.model;

import android.content.ContentValues;

import com.shinav.gcmnetworkmanagerdemo.db.table.PhoneTable;

public class Phone {
    public String model;
    public String brand;

    public Phone(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(PhoneTable.MODEL, model);
        values.put(PhoneTable.BRAND, brand);

        return values;
    }
}
