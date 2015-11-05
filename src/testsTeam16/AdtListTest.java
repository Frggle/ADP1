package testsTeam16;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.AdtListImpl;
import interfaces.AdtList;

public class AdtListTest {

	@Test
	public void testRetrieveAfterInsertInOccupiedPos() {
		AdtList list = AdtListImpl.create();
		list.insert(1, 1);
		list.insert(2, 2);
		list.insert(3, 3);
		list.insert(2, 99);
		
		assertEquals("Laenge should be the same ",4, list.laenge());
		
		int actualIntAtPosTwo = list.retrieve(2);
		
		assertEquals("Value at this pos should be the same ",99, actualIntAtPosTwo);
	}
	
	@Test
	public void testInsertBigNumberOfElem() throws Exception {
		AdtList list = AdtListImpl.create();
		int insertThis = 1;
		for (int i = 1; i <= 2005; i++) {
			list.insert(i, insertThis);
			insertThis++;
		}
		int actualIntAtPos = list.retrieve(2005);
		assertEquals("Value at this pos should be equal ",2005, actualIntAtPos);
	}
	
	@Test
	public void testInsertBigNumberOfElemAndDelete() throws Exception {
		AdtList list = AdtListImpl.create();
		
		// Insert first
		int insertThis = 1;
		for (int i = 1; i <= 2005; i++) {
			list.insert(i, insertThis);
			insertThis++;
		}
		// And delete all
		while(!list.isEmpty()) {
			list.delete(1);
		}
		int actualLaenge = list.laenge();
		assertEquals(0, actualLaenge);
	}
	
	@Test
	public void testFindElem() throws Exception {
		AdtList list = AdtListImpl.create();
		int insertThis = 0;
		for (int i = 1; i <= 10; i++) {
			list.insert(i, ++insertThis);
		}
		assertEquals("Pos should be equal ",1, list.find(1));
		assertEquals("Pos should be equal ",10, list.find(10));
	}
	
	@Test
	public void testFindNonExistentElem() throws Exception {
		AdtList list = AdtListImpl.create();
		list.insert(1, 11);
		list.insert(2, 22);
		assertEquals("Should return -1 ",-1, list.find(999));
	}
	
	@Test
	public void testRetrieveNonExistentElem() throws Exception {
		AdtList list = AdtListImpl.create();
		list.insert(1, 11);
		list.insert(2, 22);
		
		assertEquals("Should return Error Value -99999999 ",-99999999, list.retrieve(6));
	}
	
	@Test
	public void testIsEmptyWhenNotEmpty() throws Exception {
		AdtList list = AdtListImpl.create();
		list.insert(1, 11);
		list.insert(2, 22);
		
		assertFalse("List shouldn't be empty ",list.isEmpty());
	}

	@Test
	public void testLaenge() throws Exception {
		AdtList list = AdtListImpl.create();
		int insertThis = 0;
		for (int i = 1; i <= 100; i++) {
			list.insert(i, ++insertThis);
		}
		assertEquals(100, list.laenge());
	}
	
	@Test
	public void testDeleteWhenListIsEmpty() throws Exception {
		AdtList list = AdtListImpl.create();
		boolean success = false;
		try {
			list.delete(1);
			success = true;
		} catch (Exception e) {}
		assertTrue("Delete pos in empty list should've been ignored",success);
	}
	
	@Test
	public void testDeleteNonexistentPos() throws Exception {
		AdtList list = AdtListImpl.create();
		list.insert(1, 99);
		boolean success = false;
		try {
			list.delete(10);
			list.delete(0);
			list.delete(-10);
			success = true;
		} catch (Exception e) {}
		assertTrue("Delete nonexistent Pos should've been ignored ",success);
	}
	
	@Test
	public void testConcat() throws Exception {
		AdtList list1 = AdtListImpl.create();
		list1.insert(1, 11);
		list1.insert(2, 22);
		AdtList list2 = AdtListImpl.create();
		list2.insert(1, 11);
		list2.insert(2, 22);
		
		AdtList newList = list1.concat(list2);
		
		assertEquals("Value at this Pos should be equal ",11, newList.retrieve(1));
		assertEquals("Value at this Pos should be equal ",22, newList.retrieve(2));
		assertEquals("Value at this Pos should be equal ",11, newList.retrieve(3));
		assertEquals("Value at this Pos should be equal ",22, newList.retrieve(4));
	}
	
	@Test
	public void testConcatWhenOtherListIsEmpty() throws Exception {
		AdtList list1 = AdtListImpl.create();
		list1.insert(1, 11);
		list1.insert(2, 22);
		AdtList list2 = AdtListImpl.create();
		
		AdtList newList = list1.concat(list2);
		
		assertEquals("Value at this Pos should be equal ",11, newList.retrieve(1));
		assertEquals("Value at this Pos should be equal ",22, newList.retrieve(2));
		assertEquals("Value at this Pos should be equal ",-99999999, newList.retrieve(3));
	}
	
	@Test
	public void testConcatWhenBothListsAreEmpty() throws Exception {
		AdtList list1 = AdtListImpl.create();
		AdtList list2 = AdtListImpl.create();
		
		AdtList newlist = list1.concat(list2);
		assertTrue(newlist.isEmpty()); 
	}
}
