package com.example.bundle1;

public class NWW {
    public int nww(int a, int b) {
        int w = a * b;
        while (a != b) {
            if (a > b)  a -= b;
            else        b -= a;
        }
        return w / a;
    }
}
