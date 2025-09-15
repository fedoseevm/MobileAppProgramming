package com.example.algorytmluhna;

import junit.framework.TestCase;

public class AlgorytmLuhnaTest extends TestCase {
    //4791-3123-5210-5534
    //8791 6143 1220 1564 = 60

    //4566-9457-2958-0997
    //8536 9417 4918 0997 = 90
    public void testSuma1() {
        AlgorytmLuhna luhna = new AlgorytmLuhna();
        int result = luhna.Suma("4791312352105534");
        assertEquals(60, result);
    }

    public void testSuma2() {
        AlgorytmLuhna luhna = new AlgorytmLuhna();
        int result = luhna.Suma("4566945729580997");
        assertEquals(90, result);
    }
}