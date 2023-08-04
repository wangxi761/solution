package leetcode.problems._101_200.Word_Break;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (String word : wordDict) {
				if (i >= word.length() && dp[i - word.length()] && Objects.equals(s.substring(i - word.length(), i), word)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: s = "leetcode", wordDict = ["leet","code"]
		//Output: true
		//Explanation: Return true because "leetcode" can be segmented as "leet code".
		//Example 2:
		//
		//Input: s = "applepenapple", wordDict = ["apple","pen"]
		//Output: true
		//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
		//Note that you are allowed to reuse a dictionary word.
		//Example 3:
		//
		//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
		//Output: false
		Assertions.assertTrue(wordBreak("leetcode", List.of("leet", "code")));
		Assertions.assertTrue(wordBreak("applepenapple", List.of("apple", "pen")));
		Assertions.assertFalse(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
		
	}
}