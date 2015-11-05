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
        assertTrue(_stack.isEmptyS());
    }
    
    /**
     * Prueft ob die Queue leer ist -> ist nicht leer
     */
    @Test
    public void testIsEmptySNegative()
    {
        _stack.push(10);
        assertFalse(_stack.isEmptyS());
    }
    
    /**
     * Prueft ob vor dem einfuegen der Stack leer ist und danach nicht mehr
     */
    @Test
    public void testPushTrue()
    {
        assertTrue(_stack.isEmptyS());
        _stack.push(10);
        assertFalse(_stack.isEmptyS());
    }
    
    /**
     * Prueft ob vor dem einfuegen der Stack leer ist, fuegt dann eins ein und entfernt es wieder
     * danach prueft er ob es wieder leer ist
     */
    @Test
    public void testPopTrue() {
        assertTrue(_stack.isEmptyS());
        _stack.push(10);
        _stack.pop();
        assertTrue(_stack.isEmptyS());
    }
    
    /**
     * Prueft ob von einem leeren Stack ein Element entfernt werden kann
     */
    @Test
    public void testPopNegative() {
        assertTrue(_stack.isEmptyS());
        AdtStack expected = _stack;
        _stack.pop();
        assertTrue(_stack.isEmptyS());
        assertEquals(expected, _stack);
    }
    
    /**
     * Prueft ob das zuletzthinzugefuegt Element gleich dem Element ist welches herausgenommen wird
     */
    @Test
    public void testTopTrue() {
        assertTrue(_stack.isEmptyS());
        int expected = 10;
        _stack.push(expected);
        int elem = _stack.top();
        assertEquals(expected, elem);
    }
    
    @Test
    public void testTopTrue2() {
        assertTrue(_stack.isEmptyS());
        _stack.push(10);
        _stack.push(20);
        _stack.push(30);
        assertEquals(30, _stack.top());
    }
    
    /**
     * Prueft ob beim herausnehmen aus einem leere Stack ein Fehler beworfen wird
     */
    @Test
    public void testTopNegative() {
        assertTrue(_stack.isEmptyS());
        assertEquals(-99999999, _stack.top());
    }
}
