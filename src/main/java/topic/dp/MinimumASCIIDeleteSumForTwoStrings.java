package topic.dp;

public class MinimumASCIIDeleteSumForTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
		int[] dp = new int[s2.length() + 1];
		for (int i = 0; i < s1.length(); i++) {
			int last = dp[0];
			for (int j = 1; j < dp.length; j++) {
				if (s1.charAt(i) == s2.charAt(j - 1)) {
					dp[j] = last + s1.charAt(i);
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				last = dp[j];
			}
		}
		int sum = 0;
		for (char c : s1.toCharArray()) {
			sum += c;
		}
		for (char c : s2.toCharArray()) {
			sum += c;
		}
		return sum - 2 * dp[dp.length - 1];
	}
	
	
	public int minimumDeleteSum1(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int sum = 0;
		for (char c : s1.toCharArray()) {
			sum += c;
		}
		for (char c : s2.toCharArray()) {
			sum += c;
		}
		return sum - 2 * dp[dp.length - 1][dp[0].length - 1];
	}
}
