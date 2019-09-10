package topic.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int i = 0, j = 0;
		while (i < nums1.length || j < nums2.length) {
		
		}
	}
	
	public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(list -> list.get(0) + list.get(1)));
		for (int i : nums1) {
			for (int j : nums2) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				list.add(j);
				pq.offer(list);
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			List<Integer> poll = pq.poll();
			if (poll == null) continue;
			res.add(poll);
		}
		return res;
	}
}
