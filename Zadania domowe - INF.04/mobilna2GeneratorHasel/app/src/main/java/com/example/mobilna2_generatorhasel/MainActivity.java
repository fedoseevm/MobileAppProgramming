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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
                    int zlozonoscHasla = 0;

                    seekBarIloscZnakow = findViewById(R.id.seekBar_ilosc_znakow);
                    final int iloscHasel = Integer.parseInt(spinnerLiczbaHasel.getSelectedItem().toString());
                    final int iloscZnakow = seekBarIloscZnakow.getProgress();
                    zlozonoscHasla += iloscZnakow;

                    String pulaZnakow = "";
                    if (cbCyfry.isChecked()) {
                        pulaZnakow += "0123456789";
                        zlozonoscHasla += 10;
                    }
                    if (cbMaleLitery.isChecked()) {
                        pulaZnakow += "qwertyuiopasdfghjklzxcvbnm";
                        zlozonoscHasla += 10;
                    }
                    if (cbWielkieLitery.isChecked()) {
                        pulaZnakow += "QWERTYUIOPASDFGHJKLZXCVBNM";
                        zlozonoscHasla += 15;
                    }
                    if (cbZnakiSpecjalne.isChecked()) {
                        pulaZnakow += "!@#$%^&*";
                        zlozonoscHasla += 20;
                    }

                    ivSilaHasla = findViewById(R.id.iv_sila_hasla);
                    if (zlozonoscHasla < 30) {
                        ivSilaHasla.setImageResource(R.drawable.slabe);
                    }
                    else if (zlozonoscHasla < 50) {
                        ivSilaHasla.setImageResource(R.drawable.srednie);
                    }
                    else {
                        ivSilaHasla.setImageResource(R.drawable.mocne);
                    }

                    textWynik = findViewById(R.id.tv_wynik);
                    String wynik = "Siła hasła: " + zlozonoscHasla + "\n";
                    if (rgTryb.getCheckedRadioButtonId() != R.id.rb_zaawansowany) {
                        for (var i = 0; i < iloscHasel; i++) {
                            wynik += generujHaslo(pulaZnakow, iloscZnakow, new Random()) + "\n";
                        }
                    }
                    else {
                        for (var i = 0; i < iloscHasel; i++) {
                            wynik += generujZaawansowaneHaslo(pulaZnakow, iloscZnakow, new Random()) + "\n";
                        }
                    }
                    textWynik.setText(wynik);

                    switchUstawienia = findViewById(R.id.switch_ustawienia);
                    if (!switchUstawienia.isChecked()) {
                        seekBarIloscZnakow.setProgress(12);

                        cbMaleLitery.setChecked(false);
                        cbWielkieLitery.setChecked(false);
                        cbCyfry.setChecked(false);
                        cbZnakiSpecjalne.setChecked(false);

                        spinnerLiczbaHasel.setSelection(0);

                        rgTryb.clearCheck();
                    }
                }
            }

            private String generujZaawansowaneHaslo(String pulaZnakow, int iloscZnakow, Random random) {
                String preHaslo = "";
                String haslo = "";

                preHaslo += pulaZnakow.charAt(random.nextInt(10))
                        + pulaZnakow.charAt(random.nextInt(26) + 10)
                        + pulaZnakow.charAt(random.nextInt(26) + 36)
                        + pulaZnakow.charAt(random.nextInt(8) + 62);

                for (var i = 0; i < iloscZnakow - 4; i++) {
                    preHaslo += pulaZnakow.charAt(random.nextInt(pulaZnakow.length()));
                }

                List<Character> listaZnakowHasla = new ArrayList<>();

                for (var i = 0; i < preHaslo.length(); i++) {
                    listaZnakowHasla.add(preHaslo.charAt(i));
                }

                Collections.shuffle(listaZnakowHasla);

                for (var i = 0; i < listaZnakowHasla.size(); i++) {
                    haslo += listaZnakowHasla.get(i);
                }

                return haslo;
            }

            private String generujHaslo(String pulaZnakow, int iloscZnakow, Random random) {
                String haslo = "";
                for (var i = 0; i < iloscZnakow; i++) {
                    haslo += pulaZnakow.charAt(random.nextInt(pulaZnakow.length()));
                }
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