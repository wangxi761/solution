package study.dp.pack;

import static util.ArrayUtil.prettyPrint;

public class ZeroOnePack {
	//背包问题最简易解法，dp双重循环
	public int packSolution1(int[] w, int[] c, int V) {
		int[][] dp = new int[w.length + 1][V + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < c[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i - 1]] + w[i - 1]);
				}
			}
		}
		prettyPrint(dp);
		return dp[w.length][V];
	}
	
	//基于1的优化，第二重循环只需要从c[i]-1开始
	public int packSolution2(int[] w, int[] c, int V) {
		int[][] dp = new int[w.length + 1][V + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = c[i - 1] - 1; j < dp[0].length; j++) {
				if (j < c[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i - 1]] + w[i - 1]);
				}
			}
		}
		prettyPrint(dp);
		return dp[w.length][V];
	}
	
	//基于2的降维优化，空间复杂度优化到o(n)
	public int packSolution3(int[] w, int[] c, int V) {
		int[] dp = new int[V + 1];
		for (int i = 1; i < w.length + 1; i++) {
			for (int j = dp.length - 1; j >= c[i - 1] - 1; j--) {
				if (j < c[i - 1]) {
					continue;
				}
				dp[j] = Math.max(dp[j], dp[j - c[i - 1]] + w[i - 1]);
			}
		}
		prettyPrint(dp);
		return dp[V];
	}
	
	//基于3的常数优化，循环只需要到max{V-sumc(i->n),c}
	public int packSolution4(int[] w, int[] c, int V) {
		int[] dp = new int[V + 1];
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += c[i];
		}
		for (int i = 1; i < w.length + 1; i++) {
			int size = Math.max(V - sum, c[i - 1]);
			for (int j = dp.length - 1; j >= size; j--) {
				if (j < c[i - 1]) {
					continue;
				}
				dp[j] = Math.max(dp[j], dp[j - c[i - 1]] + w[i - 1]);
			}
			sum -= c[i - 1];
		}
		prettyPrint(dp);
		return dp[V];
	}
}
