package leetcode.problems._701_800.Reorganize_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
	public String reorganizeString(String s) {
		if (s == null || s.isEmpty()) return s;
		int length = s.length();
		
		int[] chs = new int[26];
		int max = 0, letter = 0;
		for (char c : s.toCharArray()) {
			chs[c - 'a']++;
			if (chs[c - 'a'] > max) {
				letter = c - 'a';
				max = chs[c - 'a'];
			}
		}
		
		if (max > (length + 1) / 2) {
			return "";
		}
		char[] ch = new char[s.length()];
		int index = 0;
		
		while (chs[letter] > 0) {
			ch[index] = (char) (letter + 'a');
			index += 2;
			chs[letter]--;
		}
		
		
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == 0) {
				continue;
			}
			while (chs[i] > 0) {
				if (index >= s.length()) {
					index = 1;
				}
				ch[index] = (char) ('a' + i);
				index += 2;
				chs[i]--;
			}
		}
		
		return new String(ch);
	}
	
	
	@Test
	public void test() {
		Assertions.assertEquals("ababa", reorganizeString("baaba"));
		Assertions.assertEquals("", reorganizeString("aaab"));
		Assertions.assertEquals("vlvov", reorganizeString("vvvlo"));
		//Example 1:
		//
		//Input: s = "aab"
		//Output: "aba"
		Assertions.assertEquals("aba", reorganizeString("aab"));
		//Example 2:
		//
		//Input: s = "aaab"
		//Output: ""
	}
}