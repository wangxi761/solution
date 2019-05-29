package topic.string;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] dp = new int[26];
		for (char c : ransomNote.toCharArray()) {
			dp[c - 'a']++;
		}
		for (char c : magazine.toCharArray()) {
			dp[c - 'a']--;
		}
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
