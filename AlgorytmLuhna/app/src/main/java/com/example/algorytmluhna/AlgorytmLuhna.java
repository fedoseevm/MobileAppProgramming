package com.example.algorytmluhna;
//4791-3123-5210-5534
//8791 6143 1220 1564 = 60

//4566-9457-2958-0997
//8536 9417 4918 0997 = 90
public class AlgorytmLuhna {
    public int Suma(String input) {
        int suma = 0;
        boolean flag = true;

        for (int i = 0; i < input.length(); i++) {
            //int digit = input.charAt(i) - '0'; // Convertation from char to int
            int digit = Character.getNumericValue(input.charAt(i));
            if (flag) digit = digit * 2;
            suma += digit % 10 + digit / 10;
            flag = !flag;
        }
        return suma;
    }
}
