package topic.heap;

import java.util.HashMap;
import java.util.Map;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] flight : flights) {
			Map<Integer, Integer> subMap = map.putIfAbsent(flight[0], new HashMap<>());
			subMap.put(flight[1], flight[2]);
		}
		
	}
}
