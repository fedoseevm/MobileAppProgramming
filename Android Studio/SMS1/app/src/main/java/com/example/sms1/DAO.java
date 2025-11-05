package com.example.sms1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    private DbHelper dbHelper;

    public long addSMS(SMS sms) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("COL_TITLE", sms.getTitle());
        cv.put("COL_MESSAGE", sms.getMessage());

        long id = db.insert("sms", null, cv);

        db.close();
        return id;
    }

    public List<SMS> getSMSList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM sms;";
        Cursor cursor = db.rawQuery(query, null);   // Wynik zapytania do bazy danych
        int id, idIndex, titleIndex, messageIndex;
        String title, message;

        List<SMS> listSMS = new ArrayList<SMS>();
        while (cursor.moveToNext()) {
            idIndex = cursor.getColumnIndex("_id");
            titleIndex = cursor.getColumnIndex("title");
            messageIndex = cursor.getColumnIndex("message");
            id = cursor.getInt(idIndex);
            title = cursor.getString(titleIndex);
            message = cursor.getString(messageIndex);
            listSMS.add(new SMS(id, title, message));
        }
        cursor.close();
        db.close();
        return listSMS;
    }
}
