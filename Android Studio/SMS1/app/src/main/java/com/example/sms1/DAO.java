package com.example.sms1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DAO {
    private DbHelper dbHelper;

    public long addSMS(SMS sms) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("COL_id", "null");
        cv.put("COL_TITLE", sms.getTitle());
        cv.put("COL_MESSAGE", sms.getTitle());

        long id = db.insert("sms", null, cv);

        db.close();
        return id;
    }
}
