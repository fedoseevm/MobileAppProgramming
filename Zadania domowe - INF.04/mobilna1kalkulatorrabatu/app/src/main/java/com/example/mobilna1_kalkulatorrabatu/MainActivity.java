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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnOblicz = findViewById(R.id.btn_oblicz);
        btnOblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textRabat.setText("Rabat: fsdf");

//                etCena = findViewById(R.id.et_cena);
//                String inputCena = etCena.getText().toString().trim();
//                try {
//                    int cena = Integer.parseInt(inputCena);
//                    if (cena < 10 || cena > 10000) {
//                        throw new NumberFormatException();
//                    }
//                }
//                catch (NumberFormatException e) {
//                    Toast.makeText(MainActivity.this, "Cena musi być liczbą dodatnią (10-10000 zł)", Toast.LENGTH_SHORT).show();
//                    return;
//                }
            }
        });
    }
}