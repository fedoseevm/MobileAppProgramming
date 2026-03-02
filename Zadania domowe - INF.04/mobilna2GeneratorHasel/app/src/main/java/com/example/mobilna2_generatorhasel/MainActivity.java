package com.example.mobilna2_generatorhasel;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textDlugoscHasla, textWynik;
    SeekBar seekBarIloscZnakow;
    CheckBox cbMaleLitery, cbWielkieLitery, cbCyfry, cbZnakiSpecjalne;
    Spinner spinnerLiczbaHasel;
    RadioGroup rgTryb;
    Switch switchUstawienia;
    Button btnGeneruj;
    ImageView ivSilaHasla;

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

        spinnerLiczbaHasel = findViewById(R.id.spinner_liczba_hasel);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.liczba_hasel,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerLiczbaHasel.setAdapter(arrayAdapter);

        cbMaleLitery = findViewById(R.id.cb_male_litery);
        cbWielkieLitery = findViewById(R.id.cb_wielkie_litery);
        cbCyfry = findViewById(R.id.cb_cyfry);
        cbZnakiSpecjalne = findViewById(R.id.cb_znaki_specjalne);

        btnGeneruj = findViewById(R.id.btn_generuj);
        btnGeneruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDlugoscHasla = findViewById(R.id.tv_dlugosc_hasla);
                textDlugoscHasla.setText(getString(R.string.dlugosc_hasla));

                if (!cbMaleLitery.isChecked() && !cbWielkieLitery.isChecked() && !cbCyfry.isChecked() && !cbZnakiSpecjalne.isChecked()) {
                    Toast.makeText(MainActivity.this, "Minimum 1 Checkbox musi być zaznaczony!", LENGTH_SHORT).show();
                }
                else {
                    seekBarIloscZnakow = findViewById(R.id.seekBar_ilosc_znakow);
                    final int iloscHasel = Integer.parseInt(spinnerLiczbaHasel.getSelectedItem().toString());
                    final int iloscZnakow = seekBarIloscZnakow.getProgress();
                    String pulaZnakow = "";
                    if (cbCyfry.isChecked()) {
                        pulaZnakow += "0123456789";
                    }
                    if (cbMaleLitery.isChecked()) {
                        pulaZnakow += "qwertyuiopasdfghjklzxcvbnm";
                    }
                    if (cbWielkieLitery.isChecked()) {
                        pulaZnakow += "QWERTYUIOPASDFGHJKLZXCVBNM";
                    }
                    if (cbZnakiSpecjalne.isChecked()) {
                        pulaZnakow += "!@#$%^&&*";
                    }

                    String wynik = "";
                    if (rgTryb.getCheckedRadioButtonId() != R.id.rb_zaawansowany) {
                        for (var i = 0; i < iloscZnakow; i++) {
                            wynik += generujHaslo(pulaZnakow);
                        }
                    }
                }
            }

            private String generujHaslo(String pulaZnakow) {
                String haslo = "";
                // Do zrobienia
                return haslo;
            }
        });

        rgTryb = findViewById(R.id.rg_tryb);
        rgTryb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_zaawansowany &&
                        (!cbCyfry.isChecked()
                        || !cbWielkieLitery.isChecked()
                        || !cbMaleLitery.isChecked()
                        || !cbZnakiSpecjalne.isChecked())) {
                    rgTryb.check(R.id.rb_podstawowy);
                    Toast.makeText(
                            MainActivity.this,
                            "Tryb zaawansowany wymaga wszystkich 4 CheckBox",
                            LENGTH_SHORT).show();
                }
            }
        });
    }
}