package topic.dp;

public class DivisorGame {
	public boolean divisorGame1(int N) {
		return N % 2 == 0;
	}
	
	public boolean divisorGame2(int N) {
		int[] dp = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			if (i < 2) {
				dp[i] = 0;
				continue;
			}
			for (int j = 1; j < i; j++) {
				if (i % j != 0) continue;
				dp[i] = dp[i - j] == 0 ? 1 : 0;
				break;
			}
		}
		return dp[N] == 1;
	}
}
