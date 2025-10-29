package com.example.baza1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class OsobaBiznes {
    MyHelper myHelper;

    OsobaBiznes(Context context) {
        myHelper = new MyHelper(context);
    }

    public void AddUser(Osoba osoba) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME_COL", osoba.getName());
        cv.put("AGE_COL", osoba.getAge());
        cv.put("HOBBY_COL", osoba.getHobby());

        long a = db.insert("osoby", null, cv);
    }
}
