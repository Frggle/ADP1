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
    
	@Test
	public void testIsEmptyTrue() {
		assertTrue(_list.isEmpty(_list));
	}
	
	@Test
	public void testIsEmptyNegative() {
        _list.insert(_list, 1, 10);
        assertFalse(_list.isEmpty(_list));
	}
	
	@Test
	public void testLaengeTrue() {
	    assertEquals(0, _list.laenge(_list));
	    _list.insert(_list, 1, 10);
	    assertEquals(1, _list.laenge(_list));
	}
	
	@Test
	public void testInsertTrue() {
	    assertTrue(_list.isEmpty(_list));
	    _list.insert(_list, 1, 10);
	    assertEquals(1, _list.laenge(_list));
	    assertEquals(10, _list.retrieve(_list, 1));
	}
	
	/**
	 * 
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
	
	@Test
    public void testInsertNegative() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 2, 10); // ungueltige Position
        assertEquals(_list, _list);
    }
	
	@Test
	public void testDeleteTrue() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.delete(_list, 1);
        assertEquals(_list, _list);
	}
	
	@Test
	public void testFindTrue() {
	    assertTrue(_list.isEmpty(_list));
	    _list.insert(_list, 1, 10);
	    _list.insert(_list, 2, 20);
	    assertEquals(2, _list.find(_list, 20));
	}
	
	@Test 
	public void testFindNegative() {
	    assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.insert(_list, 2, 20);
        assertEquals(-1, _list.find(_list, 30));
	}
	
	@Test
	public void testRetrieveTrue() {
	    assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.insert(_list, 2, 20);
        assertEquals(20, _list.retrieve(_list, 2));
	}
	
	@Test 
    public void testRetrieveNegative() {
        assertTrue(_list.isEmpty(_list));
        _list.insert(_list, 1, 10);
        _list.insert(_list, 2, 20);
        assertEquals(-99999999, _list.retrieve(_list, 3));
    }
	
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
