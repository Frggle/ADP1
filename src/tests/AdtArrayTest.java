package tests;

import static org.junit.Assert.*;
import implementations.AdtArrayImpl;
import interfaces.AdtArray;

import org.junit.Before;
import org.junit.Test;

public class AdtArrayTest
{
    private AdtArray _array = null;
        
    @Before public void init()
    {
        _array = AdtArrayImpl.initA();
    }
    
    /**
     * Testet ob die Laenge vor dem Einfuegen 0 ist und danach 1
     */
    @Test
    public void testLenghtTrue() {
        assertEquals(0, _array.lengthA());
        _array.setA(0, 10);
        assertEquals(1, _array.lengthA());
    }
        
    /**
     * Fuegt ein Element an Pos = 0 ein und prueft dann ob das Element wirklich eingefuegt war
     */
    @Test
    public void testSetATrue()
    {
        _array.setA(0, 10);
        assertEquals(1, _array.lengthA());
        int elem = _array.getA(0);
        assertEquals(10, elem);
    }
    
    /**
     * Testet ob eine ungueltige Pos (-1) das Array veraendert
     */
    @Test
    public void testSetATrue2()
    {
        assertEquals(0, _array.lengthA());
        AdtArray _tmpArray = _array;
        _array.setA(-1, 10);
        assertEquals(_tmpArray, _array);
    }
    
    /**
     * Fuegt ein Element an 0-ter Position hinzu und dann ein 2.tes Elemet an 2-ter Position
     * und prueft dann ob das Element an Position 1 mit 0 initialisiert wurde
     */
    @Test
    public void testSetATrue3()
    {
        assertEquals(0, _array.lengthA());
        _array.setA(0, 10);
        assertEquals(1, _array.lengthA());
        _array.setA(2, 10);
        assertEquals(3, _array.lengthA());
        int elem = _array.getA(1);
        assertEquals(0, elem);
    }
    
    /**
     * Fuegt ein Element an 0-ter Position hinzu und dann ein 2.tes Elemet an 2-ter Position
     * und prueft dann ob das Element an Position 1 mit 0 initialisiert wurde
     */
    @Test 
    public void testGetATrue() {
    	 assertEquals(0, _array.lengthA());
         _array.setA(0, 10);
         assertEquals(1, _array.lengthA());
         _array.setA(2, 10);
         assertEquals(3, _array.lengthA());
         int elem = _array.getA(1);
         assertEquals(0, elem);
    }
    
    /**
     * Testet ob ein leeres Array an Position -1 einen Fehler wirft
     */
    @Test
    public void testGetANegative() {
    	assertEquals(0, _array.lengthA());
    	int elem = _array.getA(-1);
    	assertEquals(0, elem);
    }
}
