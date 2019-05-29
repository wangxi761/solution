package topic.string;

import java.util.List;

public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		int[] dp = new int[24 * 60];
		for (String str : timePoints) {
			String[] split = str.split(":");
			dp[Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1])] = 1;
		}
		int min = 0, cur = 0, last = dp[0];
		for (int i : dp) {
			if (i == 0 && last == 0) {
				cur++;
			} else if (i == 1 && last == 0) {
				min = Math.min(min, cur);
				cur = 0;
			} else if (i == 0 && last == 1) {
				cur = 1;
			}
		}
		return min;
	}
}
