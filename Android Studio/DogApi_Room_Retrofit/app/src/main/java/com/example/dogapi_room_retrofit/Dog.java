package com.example.dogapi_room_retrofit;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dogs")
public class Dog {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String dogUrl;
}
