package com.example.roomhelper1;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void addNote(Note note);

    @Query("SELECT * FROM notes;")
    List<Note> getAllNotes();

    @Delete
    void removeNote(Note note);
    @Update
    void updateNote(Note note);
}
