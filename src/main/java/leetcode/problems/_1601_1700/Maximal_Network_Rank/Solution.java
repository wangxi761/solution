package leetcode.problems._1601_1700.Maximal_Network_Rank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
	public int maximalNetworkRank(int n, int[][] roads) {
		Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
		for (int[] road : roads) {
			adjacencyList.computeIfAbsent(road[0], HashSet::new).add(road[1]);
			adjacencyList.computeIfAbsent(road[1], HashSet::new).add(road[0]);
		}
		int max = 0;
		for (Integer i : adjacencyList.keySet()) {
			for (Integer j : adjacencyList.keySet()) {
				if (Objects.equals(i, j)) continue;
				max=Math.max(max,adjacencyList.get(i).size()+adjacencyList.get(j).size()+(adjacencyList.get(i).contains(j) ? -1 : 0));
			}
		}
		return max;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//
		//
		//Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
		//Output: 4
		//Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
		Assertions.assertEquals(4, maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
		//Example 2:
		//
		//
		//
		//Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
		//Output: 5
		//Explanation: There are 5 roads that are connected to cities 1 or 2.
		Assertions.assertEquals(5, maximalNetworkRank(5, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}));
		//Example 3:
		//
		//Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
		//Output: 5
		//Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.
		Assertions.assertEquals(5, maximalNetworkRank(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}));
	}
}

