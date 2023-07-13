package solution._201_300.Course_Schedule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0) return true;
		Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
		for (int[] prerequisite : prerequisites) {
			prerequisiteMap.computeIfAbsent(prerequisite[0], ArrayList::new).add(prerequisite[1]);
		}
		int[] states = new int[numCourses];
		for (Integer num : prerequisiteMap.keySet()) {
			dfs(num, prerequisiteMap, states, new boolean[numCourses]);
		}
		int count = 0;
		for (int state : states) {
			if (state == 2) count++;
		}
		return count <= 0;
	}
	
	public boolean dfs(int num, Map<Integer, List<Integer>> prerequisiteMap, int[] states, boolean[] visited) {
		if (visited[num]) {
			return false;
		}
		if (states[num] != 0) {
			return true;
		}
		states[num] = 2;
		visited[num] = true;
		List<Integer> preList = prerequisiteMap.get(num);
		boolean tag = true;
		if (preList != null) {
			for (Integer pre : preList) {
				tag = tag && dfs(pre, prerequisiteMap, states, Arrays.copyOf(visited, visited.length));
			}
		}
		states[num] = tag ? 1 : 2;
		return tag;
	}
	
	@Test
	public void test() {
		//Input: numCourses = 3, prerequisites = [[0,1],[0,2],[1,2]]
		//Output: true
		Assertions.assertEquals(true, canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
		
		//Input: numCourses = 5, prerequisites = [[1,4],[2,4],[3,1],[3,2]]
		//Output: true
		Assertions.assertEquals(true, canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
		
		Assertions.assertEquals(true, canFinish(1, new int[][]{}));
		
		//Input: numCourses = 2, prerequisites = [[1,0]]
		//Output: true
		Assertions.assertEquals(true, canFinish(2, new int[][]{{1, 0}}));
		
		//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
		//Output: false
		Assertions.assertEquals(false, canFinish(2, new int[][]{{1, 0}, {0, 1}}));
	}
}