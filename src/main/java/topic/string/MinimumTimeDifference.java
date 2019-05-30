package topic.string;

import java.util.List;

public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		int[] dp = new int[24 * 60];
		for (String str : timePoints) {
			String[] split = str.split(":");
			if (++dp[Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1])] > 1) return 0;
		}
		int pre = 0, min = Integer.MAX_VALUE;
		while (pre < dp.length && dp[pre] == 0) pre++;
		int firtst = pre;
		
		for (int i = pre + 1; i < dp.length; i++) {
			if (dp[i] == 0) continue;
			min = Math.min(min, i - pre);
			pre = i;
		}
		return Math.min(min, 24 * 60 + firtst - pre);
	}
}
