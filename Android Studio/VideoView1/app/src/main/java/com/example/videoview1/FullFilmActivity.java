package com.example.videoview1;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullFilmActivity extends AppCompatActivity {
    VideoView videoView;
    final String videoURL = "https://cdn.pixabay.com/video/2025/07/27/293788_small.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_film);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        videoView = findViewById(R.id.video1);
        Uri uri = Uri.parse(videoURL);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(mp -> {
            int videoWidth = mp.getVideoWidth();
            int videoHeight = mp.getVideoHeight();

            float videoRatio = (float) videoWidth / videoHeight;

            int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
            int screenHeight = getWindowManager().getDefaultDisplay().getHeight();

            float screenRatio = (float) screenWidth / screenHeight;

            float scaleX;
            float scaleY;

            if (videoRatio > screenRatio) {
                scaleX = 1f;
                // film szerszy niż ekran → powiększ pionowo
                scaleY = videoRatio / screenRatio;
            } else {
                scaleY = 1f;
                // film wyższy niż ekran → powiększ poziomo
                scaleX = screenRatio / videoRatio;
            }

            videoView.post(() -> {
                videoView.setPivotX(videoView.getWidth() / 2f);
                videoView.setPivotY(videoView.getHeight() / 2f);
                videoView.setScaleX(scaleX);
                videoView.setScaleY(scaleY);
            });

            videoView.start();
        });

        videoView.setOnErrorListener((mp, what, extra) -> {
            System.out.println("Video playback error: what=" + what + ", extra=" + extra);
            Toast.makeText(FullFilmActivity.this, "Video playback error: what=" + what + ", extra=" + extra, Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}