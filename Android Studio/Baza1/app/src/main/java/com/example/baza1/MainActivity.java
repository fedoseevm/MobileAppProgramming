package com.example.baza1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt;
    OsobaBiznes osobaBiznes;
    EditText t1,t2,t3;
    String stringData1, stringData2;
    int intData1;
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
        bt = findViewById(R.id.btn1);
        bt.setOnClickListener(this);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        osobaBiznes = new OsobaBiznes(this);
        stringData1 = t1.getText().toString();
        intData1 = Integer.parseInt(t2.getText().toString());
        stringData2 = t3.getText().toString();
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == bt.getId()){
            Osoba osoba = new Osoba();
            osoba.setName(stringData1);
            osoba.setAge(intData1);
            osoba.setHobby(stringData2);
        }
    }
}