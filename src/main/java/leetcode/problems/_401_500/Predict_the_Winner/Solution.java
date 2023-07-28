package leetcode.problems._401_500.Predict_the_Winner;

import java.util.Arrays;

class Solution {
	public boolean PredictTheWinner(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		for (int[] ints : dp) {
			Arrays.fill(ints, -1);
		}
		return maxDiff(dp, nums, 0, nums.length - 1)>=0;
	}
	
	public int maxDiff(int[][] dp, int[] nums, int l, int r) {
		if (dp[l][r] != -1) {
			return dp[l][r];
		}
		if (l == r) {
			return nums[l];
		}
		dp[l][r] = Math.max(nums[l] - maxDiff(dp, nums, l + 1, r), nums[r] - maxDiff(dp, nums, l, r - 1));
		return dp[l][r];
	}
	
}
