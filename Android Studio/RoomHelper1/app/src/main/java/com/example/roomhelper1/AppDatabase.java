package com.example.roomhelper1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {    // Must be abstract!
    public abstract NoteDao noteDao();
    static AppDatabase Instance;

    public static AppDatabase getInstance(Context context) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(context, AppDatabase.class, "notes.db").build();
        }
        return Instance;
    }
}
