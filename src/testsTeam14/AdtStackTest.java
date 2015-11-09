package testsTeam14;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.AdtStackImpl;
import interfaces.AdtStack;

public class AdtStackTest {

	@Test
	public void testPushAndShowTop() {
		AdtStack stack = AdtStackImpl.createS();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals("Number in Top should be the same ",3, stack.top());
	}

	@Test
	public void testPushAndPopAndShowNewTop() throws Exception {
		AdtStack stack = AdtStackImpl.createS();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.pop();
		
		assertEquals("Number in Top should be the same ",2, stack.top());
		
	}
	
	
}
