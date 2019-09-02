package topic.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < stones.length; i++) {
			queue.offer(stones[i]);
		}
		while (queue.size() > 1) {
			Integer a = queue.poll();
			Integer b = queue.poll();
			if (a != b) {
				queue.offer(a - b);
			}
		}
		return queue.size() == 0 ? 0 : queue.peek();
	}
	
}
