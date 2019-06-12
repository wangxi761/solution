package topic.Backtracking;

public class LetterTilePossibilities {
	public int numTilePossibilities(String tiles) {
		if (tiles.length() == 0) return 0;
		int[] dp = new int[26];
		for (int i = 0; i < tiles.length(); i++) {
			dp[tiles.charAt(i)]++;
		}
		int sum = 0;
		for (int i = 0; i < tiles.length(); i++) {
			sum += recursive(dp, i);
		}
		return sum;
	}
	
	public int recursive(int[] dp, int n) {
		if (n == 0) {
			int sum = 0;
			for (int i = 0; i < dp.length; i++) {
				if (dp[i] > 0) {
					sum++;
				}
			}
			return sum;
		}
		return 0;
	}
}
