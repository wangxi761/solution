package solution._1_100.Longest_Palindromic_Substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public String longestPalindromeI(String s) {
		char[] ch = s.toCharArray();
		String result = "";
		for (int i = 0; i < ch.length; i++) {
			for (int j = i; j < ch.length; j++) {
				int start = i, end = j;
				boolean tag = true;
				while (start <= end) {
					if (start == end) break;
					if (ch[start++] != ch[end--]) {
						tag = false;
						break;
					}
				}
				if (tag) {
					result = result.length() > j - i + 1 ? result : s.substring(i, j + 1);
				}
			}
		}
		return result;
	}
	
	public String longestPalindrome(String s) {
		char[] ch = s.toCharArray();
		String result = "";
		for (int i = 0; i < ch.length; i++) {
			int start = i, end = i;
			while (start >= 0 && end < ch.length) {
				if (ch[start--] != ch[end++]) break;
				result = end - start + 1 > result.length() ? s.substring(start + 1, end) : result;
			}
		}
		for (int i = 0; i < ch.length - 1; i++) {
			int start = i, end = i + 1;
			while (start >= 0 && end < ch.length) {
				if (ch[start--] != ch[end++]) break;
				result = (end - 1) - (start + 1) + 1 > result.length() ? s.substring(start + 1, end) : result;
			}
		}
		return result;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals("ccc", longestPalindrome("ccc"));
		
		
		//Input: s = "babad"
		//Output: "bab"
		Assertions.assertEquals("aba", longestPalindrome("babad"));
		
		//Input: s = "cbbd"
		//Output: "bb"
		Assertions.assertEquals("bb", longestPalindrome("cbbd"));
	}
}