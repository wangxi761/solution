package topic.heap;

import java.util.*;

public class FindKPairswithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k <= 0) return res;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
			}
		});
		for (int j = 0; j < nums2.length; j++) {
			pq.offer(new int[]{0, j});
		}
		for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
			int[] cur = pq.poll();
			res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
			if (cur[0] == nums1.length - 1) continue;
			pq.offer(new int[]{cur[0] + 1, cur[1]});
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
