package com.example.todolistviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ToDoViewModel extends ViewModel {
    private final MutableLiveData<List<ToDoItem>> todos =
            new MutableLiveData<>(new ArrayList<ToDoItem>());

    public ToDoViewModel() {
        todos.getValue().add(new ToDoItem(0, "Posprzątaj", false));
        todos.getValue().add(new ToDoItem(1, "Umyj naczynia", false));
    }

    public LiveData<List<ToDoItem>> getList() {
        return todos;
    }

    public void addItem(ToDoItem todoItem) {
        todos.getValue().add(todoItem);
    }
}
