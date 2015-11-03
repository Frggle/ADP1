package tests;

import static org.junit.Assert.*;
import implementations.AdtStackImpl;
import interfaces.AdtStack;

import org.junit.Before;
import org.junit.Test;

public class AdtStackTest
{
    private AdtStack _stack = null;
    
    @Before public void init()
    {
        _stack = AdtStackImpl.createS();
    }
    
    /**
     * Prueft ob die Queue leer ist -> ist leer
     */
    @Test
    public void testIsEmptySTrue()
    {
        assertTrue(_stack.isEmptyS(_stack));
    }
    
    /**
     * Prueft ob die Queue leer ist -> ist nicht leer
     */
    @Test
    public void testIsEmptySNegative()
    {
        _stack.push(_stack, 10);
        assertFalse(_stack.isEmptyS(_stack));
    }
    
    /**
     * Prueft ob vor dem einfuegen der Stack leer ist und danach nicht mehr
     */
    @Test
    public void testPushTrue()
    {
        assertTrue(_stack.isEmptyS(_stack));
        _stack.push(_stack, 10);
        assertFalse(_stack.isEmptyS(_stack));
    }
    
    /**
     * Prueft ob vor dem einfuegen der Stack leer ist, fuegt dann eins ein und entfernt es wieder
     * danach prueft er ob es wieder leer ist
     */
    @Test
    public void testPopTrue() {
        assertTrue(_stack.isEmptyS(_stack));
        _stack.push(_stack, 10);
        _stack.pop(_stack);
        assertTrue(_stack.isEmptyS(_stack));
    }
    
    /**
     * Prueft ob von einem leeren Stack ein Element entfernt werden kann
     */
    @Test
    public void testPopNegative() {
        assertTrue(_stack.isEmptyS(_stack));
        AdtStack expected = _stack;
        _stack.pop(_stack);
        assertTrue(_stack.isEmptyS(_stack));
        assertEquals(expected, _stack);
    }
    
    /**
     * Prueft ob das zuletzthinzugefuegt Element gleich dem Element ist welches herausgenommen wird
     */
    @Test
    public void testTopTrue() {
        assertTrue(_stack.isEmptyS(_stack));
        int expected = 10;
        _stack.push(_stack, expected);
        int elem = _stack.top(_stack);
        assertEquals(expected, elem);
    }
    
    /**
     * Prueft ob beim herausnehmen aus einem leere Stack ein Fehler beworfen wird
     */
    @Test
    public void testTopNegative() {
        assertTrue(_stack.isEmptyS(_stack));
        assertEquals(-99999999, _stack.top(_stack));
    }
}
