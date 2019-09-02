package topic.heap;

import java.util.*;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Comparator.<Map.Entry<Integer, Integer>, Integer>comparing(Map.Entry::getValue).reversed());
		for (int i = 0; i < k; i++) {
			res.add(list.get(i).getKey());
		}
		return res;
	}
	
	public List<Integer> topKFrequent1(int[] nums, int k) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int num : nums) {
			cache.put(num, cache.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
		for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
			if (queue.size() < k) {
				queue.offer(entry);
			} else if (queue.peek().getValue() < entry.getValue()) {
				queue.poll();
				queue.offer(entry);
			}
		}
		List<Integer> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			res.add(0, queue.poll().getKey());
		}
		return res;
	}
	
	public List<Integer> topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int num : nums) {
			cache.put(num, cache.getOrDefault(num, 0) + 1);
		}
		List<Integer>[] buckets = new List[nums.length + 1];
		for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
			if (buckets[entry.getValue()] == null) {
				buckets[entry.getValue()] = new ArrayList<>();
			}
			buckets[entry.getValue()].add(entry.getKey());
		}
		List<Integer> res = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
			if (buckets[i] != null) {
				res.addAll(buckets[i]);
			}
		}
		return res;
	}
}