package testsTeam16;

import static org.junit.Assert.*;

import org.junit.Test;

import implementations.AdtQueueImpl;
import interfaces.AdtQueue;

public class AdtQueueTest {

	@Test
	public void testEnqueueAndShowFront() {
		AdtQueue queue = AdtQueueImpl.createQ();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		assertEquals("Front should be the same ",1,queue.front());
		
		queue.dequeue();
		queue.dequeue();
		
		assertEquals("Front should be the same ",3, queue.front());
	}

	@Test
	public void testEnqueueAndDequeueUntilEmpty() throws Exception {
		AdtQueue queue = AdtQueueImpl.createQ();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		for (int i = 1; i <= 5; i++) {
			queue.dequeue();
		}
		assertTrue(queue.isEmptyQ());
	}
	
	@Test
	public void testShowFrontWhenQueueIsEmpty() throws Exception {
		AdtQueue queue = AdtQueueImpl.createQ();
		
		assertEquals("Error Value should be returned for front when Queue is empty ",-99999999, queue.front());
	}
	
	@Test
	public void testDequeueWhenQueueIsEmpty() throws Exception {
		AdtQueue queue = AdtQueueImpl.createQ();
		boolean success = false;
		try {
			queue.dequeue();
			success = true;
		} catch (Exception e) {}
		assertTrue("Dequeue should be ignored when Queue is epmty ",success);
	}
	
}


