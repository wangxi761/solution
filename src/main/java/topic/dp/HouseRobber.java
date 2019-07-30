package topic.dp;

public class HouseRobber {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length + 1];
		for (int i = 1; i < dp.length; i++) {
			if (i == 1) {
				dp[1] = nums[0];
				continue;
			}
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		return dp[dp.length - 1];
	}
}
