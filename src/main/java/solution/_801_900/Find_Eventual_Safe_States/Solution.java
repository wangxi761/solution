package solution._801_900.Find_Eventual_Safe_States;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	enum STATE {
		SAFE,
		UNSAFE
	}
	
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> safeNodes = new ArrayList<>();
		STATE[] states = new STATE[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (isSafe(graph, states, i)) {
				safeNodes.add(i);
			}
		}
		return safeNodes;
	}
	
	public boolean isSafe(int[][] graph, STATE[] states, int node) {
		if (states[node] != null) {
			return states[node] == STATE.SAFE;
		}
		states[node] = STATE.UNSAFE;
		
		for (int i : graph[node]) {
			if (!isSafe(graph, states, i)) {
				return false;
			}
		}
		
		states[node] = STATE.SAFE;
		return true;
	}
	
	@Test
	public void test() {
		//Input: graph = [[],[0,2,3,4],[3],[4],[]]
		//Output: [0,1,2,3,4]
		Assertions.assertEquals(List.of(0, 1, 2, 3, 4), eventualSafeNodes(new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}}));
		
		//Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
		//Output: [2,4,5,6]
		Assertions.assertEquals(List.of(2, 4, 5, 6), eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
		
		//Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
		//Output: [4]
		Assertions.assertEquals(List.of(4), eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
	}
}
