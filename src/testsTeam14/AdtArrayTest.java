package testsTeam14;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.AdtArrayImpl;
import interfaces.AdtArray;

public class AdtArrayTest {

	@Test
	public void testSetAAndGetAfterwards() {
		AdtArray array = AdtArrayImpl.initA();
		
		array.setA(0, 10);
		array.setA(1, 20);
		
		assertEquals(10, array.getA(0));
		assertEquals(20, array.getA(1));
	}
	
	@Test
	public void testSetAWithPosBiggerThanLength() throws Exception {
		AdtArray array = AdtArrayImpl.initA();
		
		array.setA(0, 10);
		array.setA(1, 20);
		array.setA(100, 3);
		
		assertEquals("Empty Space should've been filled up with 0 ",0, array.getA(2));
		assertEquals("Value at this Pos should be the same ",3, array.getA(100));
	}
	
	@Test
	public void testSetBigNumberOfIntsAndShowLength() throws Exception {
		AdtArray array = AdtArrayImpl.initA();
		int insertThis = 0;
		for (int i = 0; i <= 2005; i++) {
			array.setA(i, insertThis++);
		}
		
		assertEquals("Length of Array should be the same ",2006, array.lengthA());
		assertEquals("Value at Pos 2005 should be the same ",2005, array.getA(2005));
		 
	}

}
