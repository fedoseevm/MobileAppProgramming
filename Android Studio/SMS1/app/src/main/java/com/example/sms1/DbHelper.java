package com.example.sms1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "sms.db";
    private static final int DB_VERSION = 1;
    private final String TABLE_NAME = "sms";
    private final String COL_ID = "_id";
    private final String COL_TITLE = "title";
    private final String COL_MESSAGE = "message";

    private final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_TITLE + " VARCHAR(50), " +
            COL_MESSAGE + " VARCHAR(255));";
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
