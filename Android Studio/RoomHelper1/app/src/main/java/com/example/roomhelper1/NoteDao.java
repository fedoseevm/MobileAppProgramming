package com.example.roomhelper1;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM Note;")
    List<Note> getAllNotes();

    @Insert
    void InsertNote(Note note);
}
