package topic.string;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
	public class Element {
		int val;
		int bucket;
		int id;
		
		public Element(int val, int bucket, int id) {
			this.val = val;
			this.bucket = bucket;
			this.id = id;
		}
	}
	
	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<Element> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			Element e = new Element(nums.get(i).get(0), i, 0);
			queue.offer(e);
			max = Math.max(max, e.val);
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (queue.size() == nums.size()) {
			Element cur = queue.poll();
			if (max - cur.val < range) {
				range = max - cur.val;
				start = cur.val;
				end = max;
			}
			if (cur.id + 1 < nums.get(cur.bucket).size()) {
				cur.id++;
				cur.val = nums.get(cur.bucket).get(cur.id);
				queue.offer(cur);
				if (cur.val > max) {
					max = cur.val;
				}
			}
		}
		return new int[]{start, end};
	}
}
