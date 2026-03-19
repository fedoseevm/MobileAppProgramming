package com.example.todolistviewmodel;


public class ToDoItem {
    private int id;
    private String title;
    private boolean isDone;

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getTitle() {
        return title;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ToDoItem(int id, String title, boolean isDone) {
        this.id = id;
        this.title = title;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return id + ": " +
                title + " - " +
                (isDone ? "zrobione" : "do zrobienia");
    }
}
