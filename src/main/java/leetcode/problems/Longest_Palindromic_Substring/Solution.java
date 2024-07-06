package leetcode.problems.Longest_Palindromic_Substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */


class Solution {
	public String longestPalindrome(String s) {
		int l = 0, r = 0;
		for (int i = 0; i < s.length(); i++) {
			int oddL = expand(s, i, i);
			if (oddL > r - l + 1) {
				int dist = oddL / 2;
				l = i - dist;
				r = i + dist;
			}
			int evenL = expand((s), i, i + 1);
			if (evenL > r - l + 1) {
				int dist = evenL / 2 - 1;
				l = i - dist;
				r = i + dist + 1;
			}
		}
		return s.substring(l, r + 1);
	}
	
	private int expand(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}
	
	@Test
	public void test(){
		Assertions.assertEquals("bab", longestPalindrome("babad"));
		Assertions.assertEquals("bb", longestPalindrome("cbbd"));
		Assertions.assertEquals("a", longestPalindrome("a"));
		Assertions.assertEquals("a", longestPalindrome("ac"));
		Assertions.assertEquals("racecar", longestPalindrome("racecar"));
		Assertions.assertEquals("madam", longestPalindrome("madam"));
		Assertions.assertEquals("aa", longestPalindrome("aa"));
		Assertions.assertEquals("aaa", longestPalindrome("aaa"));
		Assertions.assertEquals("abcba", longestPalindrome("abcba"));
		Assertions.assertEquals("abccba", longestPalindrome("abccba"));	}
}