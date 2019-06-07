package study.RecursionII;

public class NQueensII {
	public int totalNQueens(int n) {
		boolean[][] dp = new boolean[n][n];
		return 0;
	}
	
	public void place_queen(int row, int n) {
	
	}
	
	
	public boolean is_not_under_attack(boolean[][] dp, int i, int j) {
		for (int k = 0; k < dp.length; k++) {
			if (dp[i][k] || dp[k][j]) {
				return false;
			}
		}
		for (int m = i, n = j; m >= 0 && m < dp.length && n >= 0 && n < dp.length; m++, n--) {
			if (dp[m][n]) {
				return false;
			}
		}
		for (int m = i, n = j; m >= 0 && m < dp.length && n >= 0 && n < dp.length; m--, n--) {
			if (dp[m][n]) {
				return false;
			}
		}
		for (int m = i, n = j; m >= 0 && m < dp.length && n >= 0 && n < dp.length; m--, n++) {
			if (dp[m][n]) {
				return false;
			}
		}
		for (int m = i, n = j; m >= 0 && m < dp.length && n >= 0 && n < dp.length; m++, n++) {
			if (dp[m][n]) {
				return false;
			}
		}
		return true;
	}
	
}
