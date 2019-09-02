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
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
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
}