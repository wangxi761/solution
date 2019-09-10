package topic.heap;

import java.util.*;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] flight : flights) {
			map.putIfAbsent(flight[0], new HashMap<>());
			map.get(flight[0]).put(flight[1], flight[2]);
		}
		Queue<Airline> queue = new PriorityQueue<>(Comparator.comparing(airline -> airline.price));
		queue.offer(new Airline(src, 0, 0));
		while (!queue.isEmpty()) {
			Airline cur = queue.poll();
			if (cur.stopTime > K + 1) {
				continue;
			} else if (cur.currentNode == dst) {
				return cur.price;
			} else if (map.containsKey(cur.currentNode)) {
				for (Map.Entry<Integer, Integer> entry : map.get(cur.currentNode).entrySet()) {
					queue.offer(new Airline(entry.getKey(), cur.stopTime + 1, cur.price + entry.getValue()));
				}
			}
		}
		return -1;
	}
	
	class Airline {
		int currentNode;
		int stopTime;
		int price;
		
		public Airline(int currentNode, int stopTime, int price) {
			this.currentNode = currentNode;
			this.stopTime = stopTime;
			this.price = price;
		}
	}
}
