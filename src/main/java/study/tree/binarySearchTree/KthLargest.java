package study.tree.binarySearchTree;

import java.util.PriorityQueue;

public class KthLargest {

	PriorityQueue<Integer> queue;
	int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		queue = new PriorityQueue<>(k);
		for (int i : nums) {
			add(i);
		}
	}

	public int add(int val) {
		if (queue.size() < k)
			queue.offer(val);
		else if(queue.peek()<val){
			queue.poll();
			queue.offer(val);
		}
		return queue.peek();
	}
}
