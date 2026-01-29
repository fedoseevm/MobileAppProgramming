package com.example.mobilna1_kalkulatorrabatu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textRabat, textWynik;
    EditText etCena;
    SeekBar seekBarProcentRabatu;
    RadioGroup rgRodzajRabatu;
    CheckBox cbCzyKartaKlienta;
    SwitchCompat switchCzyDarmowaWysylka;
    Button btnOblicz;
    ImageView imageOszednosci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rgRodzajRabatu = findViewById(R.id.rg_rodzajRabatu);
        rgRodzajRabatu.check(R.id.rb1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnOblicz = findViewById(R.id.btn_oblicz);
        btnOblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textRabat = findViewById(R.id.tv_rabat);
                textRabat.setText(getString(R.string.rabat));

                etCena = findViewById(R.id.et_cena);
                String inputCena = etCena.getText().toString().trim();
                int cena;
                try {
                    cena = Integer.parseInt(inputCena);
                    if (cena < 10 || cena > 10000) {
                        throw new NumberFormatException();
                    }
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Cena musi być liczbą dodatnią (10-10000 zł)", Toast.LENGTH_SHORT).show();
                    return;
                }

                seekBarProcentRabatu = findViewById(R.id.seekBar_procentRabatu);
                int procentRabatu = seekBarProcentRabatu.getProgress();

                switch (rgRodzajRabatu.getCheckedRadioButtonId()) {
                    case 1:
                        procentRabatu += 5;
                        break;
                    case 2:
                        procentRabatu += 10;
                        break;
                }

                cbCzyKartaKlienta = findViewById(R.id.cb_czyKarta);
                if (cbCzyKartaKlienta.isChecked()) {
                    procentRabatu += 5;
                }

//                boolean czyDarmowaWysylka = findViewById(R.id.switch_wysylka).createAccessibilityNodeInfo().isChecked();
                switchCzyDarmowaWysylka = findViewById(R.id.switch_wysylka);
                boolean czyDarmowaWysylka = switchCzyDarmowaWysylka.isChecked();

//                textRabat.setText("Rabat: " + procentRabatu + "%");
                textRabat.setText(getString(R.string.procent_rabatu, procentRabatu));
                imageOszednosci = findViewById(R.id.iv_oszczednosci);
                if (procentRabatu <= 20) {
                    imageOszednosci.setImageResource(R.drawable.oszednosci_male);
                }
                else if (procentRabatu <= 40) {
                    imageOszednosci.setImageResource(R.drawable.oszednosci_srednie);
                }
                else {
                    imageOszednosci.setImageResource(R.drawable.oszednosci_duze);
                }

                double cenaKoncowa = cena * (1 - procentRabatu / 100.0);

                textWynik = findViewById(R.id.tv_wynik);
                String wysylka = (cenaKoncowa >= 200 && czyDarmowaWysylka) ? "tak" : "nie";
//                textWynik.setText(
//                        "Cena przed: " + cena + "zł\n" +
//                        "Rabat: " + procentRabatu + "%\n" +
//                        "Cena końcowa: " + cenaKoncowa + "zł\n" +
//                        "Wysyłka: " + (cenaKoncowa >= 200 && czyDarmowaWysylka ? "tak" : "nie"));
                textWynik.setText(getString(
                        R.string.wynik,
                        cena,
                        procentRabatu,
                        cenaKoncowa,
                        wysylka
                ));
            }
        });
    }
}