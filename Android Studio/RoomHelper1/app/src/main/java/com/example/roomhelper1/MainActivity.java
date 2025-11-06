package com.example.roomhelper1;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText input1;
    Button btn1;
    ListView listView1;
    List<Note> notes = new ArrayList<Note>();
    List<Note> notesDao;
    AppDatabase appDatabase;
    ArrayAdapter<Note> arrayAdapter;

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

        input1 = findViewById(R.id.input1);
        btn1 = findViewById(R.id.btn1);
        listView1 = findViewById(R.id.listView1);

        appDatabase = AppDatabase.getInstance(getApplicationContext());
        populateLists();

        ArrayAdapter<Note> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, notes);
        listView1.setAdapter(arrayAdapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = input1.getText().toString();
                Note note = new Note(message);
                appDatabase.noteDao().addNote(note);
                populateLists();
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.layout_list_update, null);
                EditText editText1 = v.findViewById(R.id.edit1);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Warning")
                        .setMessage("Are you sure you want delete this message?")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Note note = notes.get(position);
                                        appDatabase.noteDao().removeNote(note);
                                        populateLists();
                                        arrayAdapter.notifyDataSetChanged();
                                    }
                                })
                        .setNeutralButton("Change", (dialog, which) -> {
                            new AlertDialog.Builder(MainActivity.this)
                                    .setView(v)
                                    .setTitle("Changing")
                                    .setPositiveButton("OK", (dialog1, which1) -> {
                                        Note note = notes.get(position);
                                        String newText = editText1.getText().toString();
                                        note.setMessage(newText);
                                        appDatabase.noteDao().updateNote(note);
                                        populateLists();
                                        arrayAdapter.notifyDataSetChanged();
                                    })
                                    .setNeutralButton("Cancel", null)
                                    .show();
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                return false;
            }
        });
    }

    void populateLists()
    {
        notesDao = appDatabase.noteDao().getAllNotes();
        notes.clear();
        for (var n: notesDao) {
            notes.add(n);
        }
    }
}