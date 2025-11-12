package com.example.dogapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import com.bumptech.glide.Glide;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDog;
    private Button fetchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDog = findViewById(R.id.image_view);
        fetchBtn = findViewById(R.id.fetch_btn);

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadRandomDogImage();
            }
        });
    }

    private void loadRandomDogImage() {
        DogApiService apiService = ApiClient.getClient().create(DogApiService.class);
        Call<DogResponse> call = apiService.getRandomDogImage();

        call.enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String imageUrl = response.body().getMessage();
                    Glide.with(MainActivity.this)
                            .load(imageUrl)
                            .into(imageViewDog);
                } else {
                    Toast.makeText(MainActivity.this, "Błąd odpowiedzi z serwera", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DogResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Błąd: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}