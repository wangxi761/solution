package topic.sort;

import org.junit.Test;

import java.util.PriorityQueue;

public class KClosestPointstoOriginTest {
	KClosestPointstoOrigin test = new KClosestPointstoOrigin();
	
	@Test
	public void kClosest() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.peek());
	}
}