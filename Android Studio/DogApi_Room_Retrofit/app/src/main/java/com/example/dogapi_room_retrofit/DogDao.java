package com.example.dogapi_room_retrofit;

import androidx.room.Dao;
import androidx.room.Insert;
import java.util.List;
import retrofit2.http.Query;

@Dao
public interface DogDao {
    @Query("SELECT * FROM dogs;")
    List<Dog> getAllDogs();

    @Insert
    void insertDog(Dog dog);
}
