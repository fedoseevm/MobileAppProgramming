package com.example.dogapi_room_retrofit;

import com.google.gson.annotations.SerializedName;

public class DogResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private String status;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}