package topic.heap;

import java.util.*;

public class NetworkDelayTime {
	
	
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
		for (int[] time : times) {
			cache.putIfAbsent(time[0], new HashMap<>());
			cache.get(time[0]).put(time[1], time[2]);
		}
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(i -> i[0]));
		queue.offer(new int[]{0, K});
		boolean[] visited = new boolean[N + 1];
		int res = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curNode = cur[1];
			int curDist = cur[0];
			if (visited[curNode]) continue;
			visited[curNode] = true;
			res = curDist;
			N--;
			if (cache.containsKey(curNode)) {
				for (Map.Entry<Integer, Integer> entry : cache.get(curNode).entrySet()) {
					queue.offer(new int[]{curDist + entry.getValue(), entry.getKey()});
				}
			}
		}
		return N == 0 ? res : -1;
	}
	
	
}
