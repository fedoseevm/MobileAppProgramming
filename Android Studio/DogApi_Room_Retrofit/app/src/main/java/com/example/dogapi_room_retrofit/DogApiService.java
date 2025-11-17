package com.example.dogapi_room_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApiService {
    @GET("api/breeds/image/random")
    Call<DogResponse> getRandomDogImage();
}