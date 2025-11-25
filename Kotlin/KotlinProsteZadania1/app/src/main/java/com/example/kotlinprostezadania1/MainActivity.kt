package com.example.kotlinprostezadania1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun sumaLiczbDwucyfrowych(a: Int, b: Int) : Int {
        return a + b
    }

    private fun sumaCyfr(a: Int) : Int {
        var liczba = a
        var suma = 0;

        while (liczba > 0) {
            suma += liczba % 10
            liczba /= 10
        }
        return suma
    }

    private fun dzielniki(n: Int) {
        var liczba: Int = n
        var wynik = intArrayOf(1)

        var i = 2
        do {
            if (liczba % i == 0) {
                wynik.plus(i)
            }
            i++
        } while (i <= liczba)
        print(wynik.toList())
    }

    private fun stworzMutableList() {
        var lista = mutableListOf<Int>()    // Utworzenie pustej listy
        lista.add(1)
        print(lista)
        lista.add(2)
        print(lista)
    }

    private fun mapaSilni() {
        var mapa = mapOf<Int,Int>()

        val n1 = readLine()!!.toInt()
        val n2 = readLine()!!.toInt()
        val n3 = readLine()!!.toInt()

        mapa.plus(Pair<Int,Int>(n1, silnia(n1)))
        mapa.plus(Pair<Int,Int>(n2, silnia(n2)))
        mapa.plus(Pair<Int,Int>(n3, silnia(n3)))
        print(mapa.toList())
    }

    private fun silnia(n: Int): Int {
        var wynik: Int = 1

        for (i in 2..wynik) {
            wynik *= i
        }
        return wynik
    }
 }