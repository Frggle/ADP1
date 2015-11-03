package tests;

import static org.junit.Assert.*;
import implementations.AdtListImpl;
import interfaces.AdtList;

import org.junit.Before;
import org.junit.Test;

public class AdtListTest {
	
    private AdtList _list;
    
    @Before public void init()
    {
        _list = AdtListImpl.create();
    }
    
    /**
     * Prueft ob eine nicht befuellte Liste leer ist
     */
	@Test
	public void testIsEmptyTrue() {
		assertTrue(_list.isEmpty(_list));
	}
	
	/**
	 * Prueft ob nach dem Einfuegen die Liste nicht mehr leer ist
	 */
	@Test
	public void testIsEmptyNegative() {
        _list.insert(_list, 1, 10);
        assertFalse(_list.isEmpty(_list));
	}
	
	/**
	 * Prueft ob die Laenge vor dem Einfuegen 0 (leer ist) und danach die Laenge 1 hat
	 */
	@Test
	public void testLaengeTrue() {
	    assertEquals(0, _list.laenge(_list));
	    _list.insert(_list, 1, 10);
	    assertEquals(1, _list.laenge(_list));
	}
	
	/**
	 * Prueft ob nach dem Einfuegen die Laenge 1 ist und 
	 * anschlieﬂend ob das Element in der Liste das selbe ist welches eingefuegt wurde
	 */
	@Test
	public void testInsertTrue() {
	    assertTrue(_list.isEmpty(_list));
	    _list.insert(_list, 1, 10);
	    assertEquals(1, _list.laenge(_list));
	    assertEquals(10, _list.retrieve(_list, 1));
	}
	
	/**
	 * Die Liste wird intern mit einem Array der Laenge 100 repraesentiert
	 * Prueft ob 101 Elemente eingefuegt werden koennen
	 */
	@Test
	public void testInsertTrue100() {
	    assertTrue(_list.isEmpty(_list));
	    for(int i = 1; i <= 100; i++) {
	        _list.insert(_list, i, i);
	        assertEquals(i, _list.laenge(_list));
	    }
	    _list.insert(_list, _list.laenge(_list) + 1, 5000);
	    assertEquals(101, _list.laenge(_list));
	}
	
	/**
	 * Prueft ob eine Liste unveraendert bleibt, wenn an einer ungueltigen Position etwas eingefuegt wird
	 */
	@Test
    public void testInsertNegative() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 2, 10); // ungueltige Position
        assertEquals(_list, _list);
    }
	
	/**
	 * Prueft ob die Liste gleich der Liste ist nachdem ein Element eingefuegt und direkt wieder entfernt wurde
	 */
	@Test
	public void testDeleteTrue() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.delete(_list, 1);
        assertEquals(_list, _list);
	}
	
	/**
	 * Prueft ob die richtige Position eines Elements aus der Liste zurueckgegeben wird
	 */
	@Test
	public void testFindTrue() {
	    assertTrue(_list.isEmpty(_list));
	    _list.insert(_list, 1, 10);
	    _list.insert(_list, 2, 20);
	    assertEquals(2, _list.find(_list, 20));
	}
	
	/**
     * Prueft ob bei zwei gleichen Elementen das erste Element gefunden wird
     */
    @Test
    public void testFindTrue2() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 20);
        _list.insert(_list, 2, 20);
        assertEquals(1, _list.find(_list, 20));
    }
	
    /**
     * Prueft ob ein Fehler geworfen wird, wenn ein nicht vorhandenes Element gesucht wird
     */
	@Test 
	public void testFindNegative() {
	    assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.insert(_list, 2, 20);
        assertEquals(-1, _list.find(_list, 30));
	}
	
	/**
	 * Prueft ob das richtige Element zurueckgegeben wird, wenn nach einer Position gesucht wird
	 */
	@Test
	public void testRetrieveTrue() {
	    assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.insert(_list, 2, 20);
        assertEquals(20, _list.retrieve(_list, 2));
	}
	
	/**
	 * Prueft ob ein Fehler geworfen wird, wenn nach einer ungueltigen Position gesucht wird
	 */
	@Test 
    public void testRetrieveNegative() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.insert(_list, 2, 20);
        assertEquals(-99999999, _list.retrieve(_list, 3));
    }
	
	/**
	 * Prueft ob 2 konkatenierte Listen eine neue Liste ergeben und diese identisch sind
	 */
	@Test
	public void testConcatTrue() {
	    AdtList _list2 = AdtListImpl.create();
	    AdtList _expectedList = AdtListImpl.create();
	    
	    assertTrue(_list.isEmpty(_list));
	    assertTrue(_list2.isEmpty(_list2));
	    
	    _list.insert(_list, 1, 10);
	    _list.insert(_list, 2, 20);
	    _list.insert(_list, 3, 30);
	    _list2.insert(_list2, 1, 30);
	    _list2.insert(_list2, 2, 40);
	    
	    _expectedList.insert(_expectedList, 1, 10);
	    _expectedList.insert(_expectedList, 2, 20);
	    _expectedList.insert(_expectedList, 3, 30);
	    _expectedList.insert(_expectedList, 4, 30);
	    _expectedList.insert(_expectedList, 5, 40);
	    
	    _list.concat(_list, _list2);
	    
	    assertEquals(_expectedList, _list);
	}
	
}
