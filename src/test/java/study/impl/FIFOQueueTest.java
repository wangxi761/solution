package study.impl;

import org.junit.Test;

public class FIFOQueueTest {
	FIFO_Queue test = new FIFO_Queue();
	
	@Test
	public void test() {
		test.offer(1);
		test.offer(2);
		System.out.println(test.poll());
		System.out.println(test.poll());
	}
}