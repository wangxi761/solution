package solution._1371_1380;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
	
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		int max = Integer.MIN_VALUE;
		for (int item : manager) {
			int count = 0;
			int leader = item;
			while (leader != -1) {
				count += informTime[leader];
				leader = manager[leader];
			}
			max = Math.max(max, count);
		}
		return max;
	}
	
	public int numOfMinutesI(int n, int headID, int[] manager, int[] informTime) {
		int[] cache = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < manager.length; i++) {
			int count = 0;
			int leader = manager[i];
			while (leader != -1) {
				count += informTime[leader];
				if (cache[leader] != 0) {
					count += cache[leader];
					break;
				}
				leader = manager[leader];
			}
			cache[i] = count;
			max = Math.max(max, count);
		}
		return max;
	}
	
	public int numOfMinutesII(int n, int headID, int[] manager, int[] informTime) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < manager.length; i++) {
			List<Integer> list = graph.getOrDefault(manager[i], new ArrayList<>());
			list.add(i);
			graph.put(manager[i], list);
		}
		return dfs(graph, informTime, headID);
	}
	
	public int dfs(Map<Integer, List<Integer>> graph, int[] informTime, int root) {
		int max = 0;
		if (!graph.containsKey(root)) {
			return max;
		}
		List<Integer> list = graph.get(root);
		for (Integer item : list) {
			max = Math.max(max, dfs(graph, informTime, item));
		}
		return max + informTime[root];
	}
	
	
	@Test
	public void test() {
		Assertions.assertEquals(3, numOfMinutesII(15, 0, new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}));
	}
}
