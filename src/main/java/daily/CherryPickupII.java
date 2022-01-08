package daily;

import org.junit.jupiter.api.Test;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int w = grid[0].length;
        int h = grid.length;
        Integer[][][] dp = new Integer[h][w][w];
        return dfs(dp, grid, h, w, 0, 0, w - 1);
    }

    public int dfs(Integer[][][] dp, int[][] grid, int h, int w, int r, int c1, int c2) {
        if (r == h) {
            return 0;
        }
        if (dp[r][c1][c2] != null) return dp[r][c1][c2];
        int ans = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int nc1 = c1 + i, nc2 = c2 + j;
                if (nc1 >= 0 && nc1 < w && nc2 >= 0 && nc2 < w) {
                    ans = Math.max(ans, dfs(dp, grid, h, w, r + 1, nc1, nc2));
                }
            }
        }
        int c = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        return dp[r][c1][c2] = ans + c;

    }

    @Test
    public void test() {

    }
}
