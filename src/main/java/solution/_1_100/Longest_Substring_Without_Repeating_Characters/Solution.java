package solution._1_100.Longest_Substring_Without_Repeating_Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int lengthOfLongestSubstringI(String s) {
		int max = 0;
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int len = 0;
			Set<Character> set = new HashSet<>();
			for (int j = i; j < charArray.length; j++) {
				if (set.contains(charArray[j])) {
					break;
				}
				set.add(charArray[j]);
				len++;
			}
			max = Math.max(max, len);
		}
		return max;
	}
	
	public int lengthOfLongestSubstringII(String s) {
		int max = 0;
		char[] charArray = s.toCharArray();
		int left = 0, right = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (left < s.length() && right < s.length()) {
			if (map.containsKey(charArray[right])) {
				max = Math.max(max, right - left);
				int ol = left;
				left = map.get(charArray[right]) + 1;
				for (int i = ol; i < left; i++) {
					map.remove(charArray[i]);
				}
			}
			map.put(charArray[right], right);
			right++;
		}
		if (right == s.length()) max = Math.max(max, right - left);
		return max;
	}
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		char[] ch = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; i < ch.length; i++) {
			if (map.containsKey(ch[i])) {
				j = Math.max(j, map.get(ch[i]) + 1);
			}
			map.put(ch[i], i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
	
	
	@Test
	public void test() {
		Assertions.assertEquals(3, lengthOfLongestSubstring("dvdf"));
		Assertions.assertEquals(2, lengthOfLongestSubstring("abba"));
		Assertions.assertEquals(2, lengthOfLongestSubstring("aab"));
		Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
		Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
		Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
		Assertions.assertEquals(4, lengthOfLongestSubstring("abcd"));
	}
}


