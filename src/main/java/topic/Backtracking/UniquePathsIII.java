package topic.backtracking;

public class UniquePathsIII {
	public int uniquePathsIII(int[][] grid) {
		int empty = 1, sx = 0, sy = 0, ex = 0, ey = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					empty++;
				} else if (grid[i][j] == 1) {
					sx = i;
					sy = j;
				} else if (grid[i][j] == 2) {
					ex = i;
					ey = j;
				}
			}
		}
		return dfs(grid, sx, sy, ex, ey, empty);
	}
	
	public int dfs(int[][] gird, int sx, int sy, int ex, int ey, int empty) {
		if (sx >= gird.length || sy >= gird[0].length || sx < 0 || sy < 0 || gird[sx][sy] < 0) {
			return 0;
		} else if (sx == ex && sy == ey) {
			if (empty == 0) {
				return 1;
			}
			return 0;
		} else {
			gird[sx][sy] = -2;
			int sum = dfs(gird, sx + 1, sy, ex, ey, empty - 1) + dfs(gird, sx - 1, sy, ex, ey, empty - 1) + dfs(gird, sx, sy + 1, ex, ey, empty - 1) + dfs(gird, sx, sy - 1, ex, ey, empty - 1);
			gird[sx][sy] = 0;
			return sum;
		}
	}
}
