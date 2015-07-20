package com.shinav.gcmnetworkmanagerdemo.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shinav.gcmnetworkmanagerdemo.db.table.PhoneTable;
import com.shinav.gcmnetworkmanagerdemo.injection.annotation.ForApplication;

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "application-database.db";

    public DbOpenHelper(@ForApplication Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        createTables(db);
        addMigrations(db);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createTables(SQLiteDatabase db) {
        createTopicTable(db);
    }

    private void addMigrations(SQLiteDatabase db) {

    }

    private void createTopicTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PhoneTable.TABLE + " ("
                        + PhoneTable.ID + " INTEGER,"
                        + PhoneTable.MODEL + " TEXT,"
                        + PhoneTable.BRAND + " TEXT,"
                        + " UNIQUE (" + PhoneTable.ID + ") ON CONFLICT REPLACE)"
        );

        createIndex(db, PhoneTable.TABLE, PhoneTable.ID);
    }

    private void createIndex(SQLiteDatabase db, String tableName, String column) {
        db.execSQL("CREATE INDEX " + tableName + column +
                        " ON " + tableName + " (" + column + ")"
        );
    }

}
