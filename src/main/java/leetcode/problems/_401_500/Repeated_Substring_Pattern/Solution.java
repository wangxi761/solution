package leetcode.problems._401_500.Repeated_Substring_Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public boolean repeatedSubstringPattern(String s) {
		OUTER:
		for (int i = 1; i < s.length(); i++) {
			if (s.length() % i != 0) {
				continue;
			}
			String sub = s.substring(0, i);
			for (int j = 0; j < s.length(); j += i) {
				if (!sub.equals(s.substring(j, j + i))) {
					continue OUTER;
				}
			}
			return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: s = "abab"
		//Output: true
		//Explanation: It is the substring "ab" twice.
		//Example 2:
		//
		//Input: s = "aba"
		//Output: false
		//Example 3:
		//
		//Input: s = "abcabcabcabc"
		//Output: true
		//Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
		
		Assertions.assertTrue(repeatedSubstringPattern("abab"));
		Assertions.assertFalse(repeatedSubstringPattern("aba"));
		Assertions.assertTrue(repeatedSubstringPattern("abcabcabcabc"));
	}
}

