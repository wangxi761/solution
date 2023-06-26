package solution._2401_2500.Total_Cost_to_Hire_K_Workers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

class Solution {
	public long totalCost(int[] costs, int k, int candidates) {
		PriorityQueue<Integer> lq = new PriorityQueue<>(candidates);
		PriorityQueue<Integer> rq = new PriorityQueue<>(candidates);
		
		int left = 0, right = costs.length - 1;
		long sum = 0;
		for (int i = 0; i < k; i++) {
			while (left <= right && lq.size() < candidates) {
				lq.offer(costs[left++]);
			}
			while (left <= right && rq.size() < candidates) {
				rq.offer(costs[right--]);
			}
			
			if (!lq.isEmpty() && !rq.isEmpty() && lq.peek() <= rq.peek()) {
				sum += lq.poll();
			} else if (rq.isEmpty()) {
				sum += lq.poll();
			} else {
				sum += rq.poll();
			}
		}
		return sum;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(11, totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
		Assertions.assertEquals(4, totalCost(new int[]{1, 2, 4, 1}, 3, 3));
	}
}