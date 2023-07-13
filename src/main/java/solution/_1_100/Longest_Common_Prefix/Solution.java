package solution._1_100.Longest_Common_Prefix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public String longestCommonPrefixI(String[] strs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 200; i++) {
			char first = 0;
			for (int j = 0; j < strs.length; j++) {
				String str = strs[j];
				if (i >= str.length()) {
					return sb.toString();
				}
				char cur = str.charAt(i);
				if (j == 0) {
					first = cur;
				} else if (first == cur) {
					continue;
				} else {
					return sb.toString();
				}
			}
			sb.append(first);
		}
		return sb.toString();
	}
	
	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		OUTER:
		while (true) {
			Character c = null;
			for (String str : strs) {
				if (index >= str.length()) {
					break OUTER;
				}
				if (c == null) {
					c = str.charAt(index);
				} else {
					if (c != str.charAt(index)) {
						break OUTER;
					}
				}
			}
			sb.append(c);
			index++;
		}
		return sb.toString();
	}
	
	@Test
	public void test() {
		Assertions.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
		Assertions.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
	}
}