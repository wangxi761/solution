package topic.dp;

public class MinimumASCIIDeleteSumForTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int[][] dp = new int[2][s2.length() + 1];
		
		for (int i = 1; i < c1.length + 1; i++) {
			for (int j = 1; j < c2.length + 1; j++) {
				if (c1[i - 1] == c2[j - 1]) {
					dp[1][j] = dp[0][j - 1] + c1[i - 1];
				} else {
					dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
				}
			}
			swap(dp, 0, 1);
		}
		int sum = 0;
		for (char c : c1) {
			sum += c;
		}
		for (char c : c2) {
			sum += c;
		}
		return sum - 2 * dp[0][dp[0].length - 1];
	}
	
	private void swap(int[][] dp, int a, int b) {
		int[] c = dp[a];
		dp[a] = dp[b];
		dp[b] = c;
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
