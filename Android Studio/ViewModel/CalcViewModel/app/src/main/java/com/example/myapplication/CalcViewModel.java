package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalcViewModel extends ViewModel {
    private final MutableLiveData<String> result = new MutableLiveData<>("");

    public LiveData<String> getResult() {
        return result;
    }

    public void add(String a, String b) {
        double wynik = Double.parseDouble(a) + Double.parseDouble(b);
        result.setValue(String.valueOf(wynik));
    }
}
