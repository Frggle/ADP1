package tests;

import static org.junit.Assert.*;
import implementations.AdtQueueImpl;
import interfaces.AdtQueue;

import org.junit.Before;
import org.junit.Test;

public class AdtQueueTest
{
    private AdtQueue _queue = null;
    
    @Before public void init()
    {
        _queue = AdtQueueImpl.createQ();
    }
    
    /**
     * Prueft ob die Queue leer ist -> ist leer
     */
    @Test
    public void testIsEmptyQTrue()
    {
        assertTrue(_queue.isEmptyQ(_queue));
    }
    
    /**
     * Prueft ob die Queue leer ist -> ist nicht leer
     */
    @Test
    public void testIsEmptyQNegative()
    {
        _queue.enqueue(_queue, 10);
        assertFalse(_queue.isEmptyQ(_queue));
    }
    
    /**
     * Prueft vor dem einfuegen ob die Queue leer ist und danach nicht mehr
     */
    @Test
    public void testEnqueueTrue() {
        assertTrue(_queue.isEmptyQ(_queue));
        _queue.enqueue(_queue, 10);
        assertFalse(_queue.isEmptyQ(_queue));
    }
    
    /**
     * Fuegt 3 Elemente ein, entfernt dann 2 und prueft ob das letzte verbleibene Element das neuste Element ist 
     */
    @Test
    public void testDequeueTrue() {
        assertTrue(_queue.isEmptyQ(_queue));
        _queue.enqueue(_queue, 10);
        _queue.enqueue(_queue, 20);
        _queue.enqueue(_queue, 30);
        
        _queue.dequeue(_queue);
        assertFalse(_queue.isEmptyQ(_queue));
        _queue.dequeue(_queue);
        int elem = _queue.front(_queue);
        assertEquals(30, elem);
    }

    /**
     * Prueft ob es anfangs leer ist, dann wird ein Element entfernt (was nicht vorhanden ist)
     * danach muss die Queue weiterhin leer sein, ohne Fehler
     */
    @Test
    public void testDequeueNegative() {
        assertTrue(_queue.isEmptyQ(_queue));
        _queue.dequeue(_queue);
        assertTrue(_queue.isEmptyQ(_queue));
    }
    
    /**
     * Prueft ob das hinzugefuegte Element ausgegeben wird, und anschließend darf die Queue nicht leer sein
     */
    @Test
    public void testFrontTrue() {
        assertTrue(_queue.isEmptyQ(_queue));
        _queue.enqueue(_queue, 10);
        assertEquals(10, _queue.front(_queue));
        assertFalse(_queue.isEmptyQ(_queue));
    }
    
    /**
     * Prueft ob ein Fehler geworfen wird, wenn aus einer leeren Queue ein Element geholt wird
     */
    @Test
    public void testFrontNegative() {
        assertTrue(_queue.isEmptyQ(_queue));
        assertEquals(-99999999, _queue.front(_queue));
    }
}
