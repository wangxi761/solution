package topic.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NetworkDelayTime {
	
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
		for (int[] time : times) {
			Map<Integer, Integer> map = cache.getOrDefault(time[0], new HashMap<>());
			map.put(time[1], time[2]);
			cache.put(time[0], map);
		}
	}
	
	public void recursive(Map<Integer, Map<Integer, Integer>> cache, int k, Set<Integer> pass) {
		pass.add(k);
		if (!cache.containsKey(k)) {
			return;
		}
		for (Map.Entry<Integer, Integer> entry : cache.get(k).entrySet()) {
			entry
		}
	}
	
}
