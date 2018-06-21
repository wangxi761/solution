package solution._1_10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
	@Test
	public void test() {
		String s = "abba";
		int k = lengthOfLongestSubstringII(s);
		System.out.println(k);
	}
	public int lengthOfLongestSubstringII(String s) {
		char[] str = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < str.length; i++) {
			if(map.containsKey(str[i])) {
				j=Math.max(j, map.get(str[i])+1);
			}
			map.put(str[i], i);
			max=Math.max(max, i-j+1);
		}
		return max;
	}
	// 这个版本会超�?
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		String longest = "";
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; i++) {
			Map<Character, Boolean> map = new HashMap<>();
			for (int j = 0; j < 128; j++) {
				map.put((char) j, false);
			}
			boolean tag = true;
			int k = i;
			StringBuilder sb = new StringBuilder();
			while (tag && k < s.length()) {
				if (map.get(str[k])) {
					tag = false;
				} else {
					map.put(str[k], true);
					sb.append(str[k]);
				}
				k++;
			}
			if (longest.length() < sb.length()) {
				longest = sb.toString();
			}
		}
		return longest.length();
	}

	// 这个稍微好点也会超时
	public int lengthOfLongestSubstringI(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		String longest = "";
		char[] str = s.toCharArray();
		int i = 0, count = 0;
		while (i < str.length) {
			int k = i;
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < 128; j++) {
				map.put((char) j, null);
			}
			boolean tag = true;
			StringBuilder sb = new StringBuilder();
			while (tag && k < str.length) {
				if (map.get(str[k]) == null) {
					map.put(str[k], k);
					sb.append(str[k]);
				} else {
					tag = false;
					i = map.get(str[k]) + 1;
				}
				k++;
			}
			if (k == str.length && count++ == 1) {
				break;
			}
			if (longest.length() < sb.length()) {
				longest = sb.toString();
			}
		}
		return longest.length();
	}

	
}
