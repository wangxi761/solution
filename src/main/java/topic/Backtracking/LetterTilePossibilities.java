package topic.Backtracking;

public class LetterTilePossibilities {
	public int numTilePossibilities(String tiles) {
		if (tiles.length() == 0) return 0;
		int[] dp = new int[26];
		for (int i = 0; i < tiles.length(); i++) {
			dp[tiles.charAt(i) - 'A']++;
		}
		return recursive(dp);
	}
	
	public int recursive(int[] dp) {
		int sum = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == 0) continue;
			sum++;
			dp[i]--;
			sum += recursive(dp);
			dp[i]++;
		}
		return sum;
	}
}
