package com.example.algorytmluhna;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button losuj_btn, check_btn;
    private EditText kod, answer;
    private String CardNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        losuj_btn = findViewById(R.id.losuj_btn);
        check_btn = findViewById(R.id.check_btn);
        kod = findViewById(R.id.show_number);
        answer = findViewById(R.id.show_answer);

        losuj_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x;
                String result = "";
                Random r = new Random();
                for (int i = 0; i < 16; i++) {
                    x = r.nextInt(10);
                    result = result + x;
                    kod.setText(result);
                }
                CardNumber = result;
            }
        });

        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlgorytmLuhna luhna = new AlgorytmLuhna();
                int result = luhna.Suma(CardNumber);
                if (result % 10 == 0) {
                    answer.setText("Suma = " + result + "\nNumer poprawny");
                }
                else {
                    answer.setText("Suma = " + result + "\nNumer niepoprawny");
                }
            }
        });
    }
}