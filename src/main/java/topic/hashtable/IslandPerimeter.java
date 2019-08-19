package topic.hashtable;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) continue;
				int up = i - 1 < 0 ? 0 : grid[i - 1][j];
				int down = i + 1 >= grid.length ? 0 : grid[i + 1][j];
				int left = j - 1 < 0 ? 0 : grid[i][j - 1];
				int right = j + 1 >= grid[0].length ? 0 : grid[i][j + 1];
				res += 4 - up - down - left - right;
			}
		}
		return res;
	}
	
}
