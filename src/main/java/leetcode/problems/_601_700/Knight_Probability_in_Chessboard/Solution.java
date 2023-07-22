package leetcode.problems._601_700.Knight_Probability_in_Chessboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public double knightProbability(int n, int k, int row, int column) {
		Double[][][] dp = new Double[k + 1][n][n];
		return probability(n, k, row, column, dp);
	}
	
	public double probability(int n, int k, int row, int column, Double[][][] dp) {
		if (row < 0 || column < 0 || row >= n || column >= n) {
			return 0;
		}
		if (k == 0) {
			return 1;
		}
		if (dp[k][row][column] != null) {
			return dp[k][row][column];
		}
		double prob = 0;
		int[] ops = {2, -2, 1, -1};
		for (int opX : ops) {
			for (int opY : ops) {
				if (opX == opY || opX == -opY) {
					continue;
				}
				double subProb = ((double) 1 / 8) * probability(n, k - 1, row + opX, column + opY, dp);
				prob = prob + subProb;
			}
		}
		dp[k][row][column] = prob;
		return prob;
	}
	
	@Test
	public void test() {
		System.out.println(knightProbability(8, 30, 6, 4));
		Assertions.assertEquals(0.06250, knightProbability(3, 2, 0, 0));
		//Input: n = 3, k = 2, row = 0, column = 0
		//Output: 0.06250
		Assertions.assertEquals(0.06250, knightProbability(3, 2, 0, 0));
		//Input: n = 1, k = 0, row = 0, column = 0
		//Output: 1.00000
		Assertions.assertEquals(1.00000, knightProbability(1, 0, 0, 0));
	}
}

