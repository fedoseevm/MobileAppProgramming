package com.example.dogapi_room_retrofit;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Dog.class}, version = 1)
public abstract class DogDatabase extends RoomDatabase {
    public abstract DogDao dogDao();
    private static DogDatabase Instance;

    public static DogDatabase getInstance(Context context) {
        if (Instance == null)
            Instance = Room.databaseBuilder(context ,DogDatabase.class,"dogs.db").build();
        return Instance;
    }
}
