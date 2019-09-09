package topic.heap;

import java.util.HashMap;
import java.util.Map;

public class NetworkDelayTime {
	
	
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
		for (int[] time : times) {
			cache.putIfAbsent(time[0], new HashMap<>());
			cache.get(time[0]).put(time[1], time[2]);
		}
		
	}
	
	
}
