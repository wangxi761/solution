package topic.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwiminRisingWater {
	public int swimInWater(int[][] grid) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
			}
		});
		pq.add(new int[]{0, 0});
		int level = 0;
		int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		boolean[][] visited = new boolean[grid.length][grid.length];
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			level = Math.max(level, grid[poll[0]][poll[1]]);
			if (poll[0] == grid.length - 1 && poll[1] == grid.length - 1) {
				break;
			}
			for (int[] ne : next) {
				int x = poll[0] + ne[0];
				int y = poll[1] + ne[1];
				if (x < grid.length && y < grid.length && x >= 0 && y >= 0 && !visited[x][y]) {
					visited[x][y] = true;
					pq.offer(new int[]{x, y});
				}
			}
		}
		return level;
	}
	
	public int swimInWater1(int[][] grid) {
		int[][] max = new int[grid.length][grid[0].length];
		for (int[] ma : max) {
			for (int i = 0; i < ma.length; i++) {
				ma[i] = Integer.MAX_VALUE;
			}
		}
		recursive(grid, max, 0, 0, grid[0][0]);
		return max[grid.length - 1][grid[0].length - 1];
	}
	
	public void recursive(int[][] grid, int[][] max, int x, int y, int pre) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || Math.max(pre, grid[x][y]) >= max[x][y]) {
			return;
		}
		max[x][y] = Math.max(pre, grid[x][y]);
		recursive(grid, max, x + 1, y, max[x][y]);
		recursive(grid, max, x - 1, y, max[x][y]);
		recursive(grid, max, x, y + 1, max[x][y]);
		recursive(grid, max, x, y - 1, max[x][y]);
	}
}
