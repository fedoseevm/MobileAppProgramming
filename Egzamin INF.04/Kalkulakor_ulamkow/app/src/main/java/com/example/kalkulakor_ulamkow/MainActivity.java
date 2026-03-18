package com.example.kalkulakor_ulamkow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView wynik;
    EditText licznik1, licznik2, mianownik1, mianownik2;
    Button btnOblicz;
    ImageView obrazek;
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

        licznik1 = findViewById(R.id.licznik1);
        mianownik1 = findViewById(R.id.mianownik1);
        licznik2 = findViewById(R.id.licznik2);
        mianownik2 = findViewById(R.id.mianownik2);

        obrazek = findViewById(R.id.iv_wynik);
        wynik = findViewById(R.id.tv_wynik);

        btnOblicz = findViewById(R.id.btn_oblicz);
        btnOblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int l1, l2, m1, m2;
                try {
                    l1 = Integer.parseInt(licznik1.getText().toString());
                    l2 = Integer.parseInt(licznik2.getText().toString());
                    m1 = Integer.parseInt(mianownik1.getText().toString());
                    m2 = Integer.parseInt(mianownik2.getText().toString());
                }
                catch (Exception e) {
                    wynik.setText("Wszystkie pola muszą być wypełnione liczbami całkowitymi!");
                    return;
                }

                if (m1 == 0 || m2 == 0) {
                    wynik.setText("Mianownik nie może równać się 0");
                }
                else {
                    int licznikWynikowy = l1 * m2 + l2 * m1;
                    int mianownikWynikowy = m1 * m2;

                    int nwd = EuklidesNWD(licznikWynikowy, mianownikWynikowy);

                    licznikWynikowy /= nwd;
                    mianownikWynikowy /= nwd;

                    wynik.setText(l1 + "/" + m1 + " + " + l2 + "/" + m2 + " = " + (mianownikWynikowy == 1 ? licznikWynikowy : licznikWynikowy + "/" + mianownikWynikowy));

                    if ((double )licznikWynikowy / mianownikWynikowy > 1) {
                        obrazek.setImageResource(R.drawable.plus);
                    }
                    else {
                        obrazek.setImageResource(R.drawable.minus);
                    }
                }


            }
        });
    }

    protected int EuklidesNWD(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}