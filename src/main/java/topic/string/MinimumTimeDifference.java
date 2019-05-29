package topic.string;

import java.util.List;

public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		int[] dp = new int[24 * 60];
		for (String str : timePoints) {
			String[] split = str.split(":");
			dp[Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1])] = 1;
		}
		int min = Integer.MAX_VALUE, cur = 0, last = dp[0];
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == last) {
				cur++;
				last = dp[i];
			} else {
				if (dp[i] == 0) {
					min = Math.min(min, cur);
				} else {
					cur = 1;
				}
			}
		}
		if (dp[dp.length - 1] == dp[0] && dp[0] == 1)
			min = Math.min(1, min);
		return min;
	}
}
