package topic.heap;

import java.util.*;

public class FindKPairswithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
			res.add(Arrays.asList(nums1[i], nums2[j]));
			if (i + 1 == nums1.length && j + 1 == nums2.length) {
				break;
			} else if (i + 1 == nums1.length) {
				j++;
			} else if (j + 1 == nums2.length) {
				i++;
			} else if (nums1[i + 1] + nums2[j] > nums1[i] + nums2[j + 1]) {
				j++;
			} else {
				i++;
			}
		}
		return res;
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
