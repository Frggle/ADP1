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
    
    @Test
    public void testLenghtTrue() {
        assertEquals(0, _array.lengthA(_array));
        _array.setA(_array, 0, 10);
        assertEquals(1, _array.lengthA(_array));
    }
        
    @Test
    public void testSetATrue()
    {
        _array.setA(_array, 0, 10);
        _array.lengthA(_array);
        assertEquals(1, _array.lengthA(_array));
        int elem = _array.getA(_array, 0);
        assertEquals(10, elem);
    }
    
    @Test
    public void testSetATrue2()
    {
        assertEquals(0, _array.lengthA(_array));
        AdtArray _tmpArray = _array;
        _array.setA(_array, -1, 10);
        assertEquals(_tmpArray, _array);
    }
    
    @Test
    public void testSetATrue3()
    {
        assertEquals(0, _array.lengthA(_array));
        _array.setA(_array, 0, 10);
        assertEquals(1, _array.lengthA(_array));
        _array.setA(_array, 2, 10);
        assertEquals(3, _array.lengthA(_array));
        int elem = _array.getA(_array, 1);
        assertEquals(0, elem);
    }

}
