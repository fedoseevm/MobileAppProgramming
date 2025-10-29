package com.example.baza1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "osobadb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "osoby";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "imie";

    // below variable id for our course duration column.
    private static final String AGE_COL = "wiek";

    // below variable for our course description column.
    private static final String HOBBY_COL = "hobby";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_COL + " VARCHAR(255), " +
            AGE_COL + " INTEGER, " +
            HOBBY_COL + "VARCHAR(255));";

    private static final String DROP_TABLE ="DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    private Context context;
    public MyHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DROP_TABLE);
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Log.d("Baza",""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
