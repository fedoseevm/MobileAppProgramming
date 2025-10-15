package com.example.bundle1;

import junit.framework.TestCase;

public class NWWTest extends TestCase {

    public void testNww() {
        NWW nww = new NWW();
        int result = nww.nww(12, 16);
        assertEquals(48, result);
    }
}